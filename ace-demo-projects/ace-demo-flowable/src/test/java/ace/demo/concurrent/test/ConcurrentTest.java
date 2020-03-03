package ace.demo.concurrent.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2019/11/14 11:40
 * @description
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)

public class ConcurrentTest {
    private Supplier<CommonResponse> createSupplier(final int id) {
        Supplier<CommonResponse> supplier = new Supplier<CommonResponse>() {
            @Override
            public CommonResponse get() {
                log.info("开始：" + id);
                CommonResponse response = new CommonResponse();
                response.setId(String.valueOf(id));
                Random random = new Random();
                int secondTime = random.nextInt(500);
                int randomValue = random.nextInt();
                try {
                    Thread.sleep(secondTime);
                    if (randomValue > 30) {
                        response.setCode("-1");
                        response.setMessage("error");
                        throw new RuntimeException();
                    } else {
                        response.setCode("1");
                        response.setMessage("success");
                    }

                } catch (RuntimeException e) {
                    throw new RuntimeException();
                } catch (Exception e) {
                    response.setCode("-1");
                    response.setMessage("InterruptedException");

                }
                return response;
            }
        };
        return supplier;
    }

    @Test
    public void testClassName() {
        System.out.println(ConcurrentTest.class.getName());
    }

    @Test
    public void testCompletableFuture() throws ExecutionException, InterruptedException {
        int limit = 100;
        List<CompletableFuture> list = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            Supplier<CommonResponse> supplier = createSupplier(i);
            CompletableFuture completableFuture = CompletableFuture
                    .supplyAsync(supplier)
                    .whenComplete((commonResponse, throwable) -> {
                        if (throwable != null) {
                            log.info("throwable");
                        }
                        log.info(JSON.toJSONString(commonResponse));
                        if (commonResponse.getCode().equalsIgnoreCase("-1")) {
                            list.stream()
                                    .forEach(p -> {
                                        //          p.is
                                        //   p.complete(null);
                                    });
                        }
                    });
            list.add(completableFuture);
        }

        CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()]))
                .whenComplete((d, ex) -> {
                            log.info("finish");
                        }
                ).get();
        log.info("finish2");
    }

    /**
     * 这个并行操作，不能立刻返回相关执行结果,用异常都不可以，除异常在main thread中
     */
    @Test
    public void testConcurrentSuspend() {
        int limit = 10000;
        List<Integer> list = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            list.add(i);
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Boolean> results = list.parallelStream()
                .map(i -> {
                    int index = atomicInteger.getAndAdd(1);
                    Random random = new Random();
                    Integer randomValue = random.nextInt(32);
                    boolean result = randomValue > 16;
                    log.info(String.format("%s:%s:%s", i, index, result));
                    if (result) {
                        throw new RuntimeException(String.valueOf(i));
                    }
                    return result;
                })
                .collect(Collectors.toList());
        log.info(JSON.toJSONString(results));
    }
}
