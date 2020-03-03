package ace.fw.ms.logic.application.autoconfigure;

import ace.fw.ms.application.autoconfigure.MsApplicationAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.*;


/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/3 14:39
 * @description
 */
@AutoConfigureAfter({
        MsApplicationAutoConfiguration.class,
})
@Configuration
public class LogicApplicationAutoConfigure {

}
