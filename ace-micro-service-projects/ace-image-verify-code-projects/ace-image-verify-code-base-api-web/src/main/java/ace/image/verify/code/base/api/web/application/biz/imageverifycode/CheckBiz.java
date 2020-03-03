package ace.image.verify.code.base.api.web.application.biz.imageverifycode;

import ace.fw.exception.BusinessException;
import ace.fw.model.response.GenericResponseExt;
import ace.image.verify.code.base.api.web.application.biz.imageverifycode.util.ImageVerifyCodeUtils;
import ace.image.verify.code.define.base.enums.ImageVerifyCodeTypeEnum;
import ace.image.verify.code.define.base.model.request.CheckRequest;
import ace.image.verify.code.define.base.model.request.GetImageVerifyCodeRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 17:32
 * @description
 */
@Component
@Slf4j
public class CheckBiz {

    @Autowired
    private RedissonClient redissonClient;


    public void execute(CheckRequest request) {
        String cacheKey = ImageVerifyCodeUtils.getCacheKey(request.getImageVerifyCodeBizId());
        RBucket<String> cacheRBucket = redissonClient.getBucket(cacheKey);
        String cacheValue = cacheRBucket.get();
        if (StringUtils.isBlank(cacheValue)) {
            throw new BusinessException("验证码已过期,请刷新");
        }
        if (cacheValue.equalsIgnoreCase(request.getImageVerifyCode()) == false) {
            throw new BusinessException("请输入正确的验证码");
        }
    }
}
