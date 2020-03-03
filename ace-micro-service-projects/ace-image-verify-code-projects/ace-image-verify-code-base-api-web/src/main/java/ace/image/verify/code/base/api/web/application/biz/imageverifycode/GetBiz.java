package ace.image.verify.code.base.api.web.application.biz.imageverifycode;

import ace.image.verify.code.base.api.web.application.biz.imageverifycode.util.ImageVerifyCodeUtils;
import ace.image.verify.code.define.base.enums.ImageVerifyCodeTypeEnum;
import ace.image.verify.code.define.base.model.request.GetImageVerifyCodeRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
public class GetBiz {

    @Autowired
    private RedissonClient redissonClient;

    private final static char[] ALPHA_NUMERIC_ALL_CHAR = "123456789qwertyuipasdfghjklmnbvcxz".toCharArray();

    public void execute(GetImageVerifyCodeRequest request) {
        //生成随机数
        String imageVerifyCode = this.newImageVerifyCode(request.getImageVerifyCodeTypeEnum(), request.getImageVerifyCodeCount());
        //在内存中创建一张图片
        BufferedImage bi = new BufferedImage(request.getImageWidth(), request.getImageHeight(), BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics g = bi.getGraphics();
        //设置图片的背影色
        setBackGround(g, request.getImageWidth(), request.getImageHeight());
        //设置图片的边框
        setBorder(g);
        //在图片上画干扰线
        drawRandomLine(g, request.getImageWidth(), request.getImageHeight());
        //在图片上画随机数
        this.drawChar((Graphics2D) g, imageVerifyCode);
        //将随机数存在session中
        String cacheKey = this.getCacheKey(request.getImageVerifyCodeBizId());

        RBucket<String> cacheRBucket = redissonClient.getBucket(cacheKey);

        cacheRBucket.set(imageVerifyCode, 5, TimeUnit.MINUTES);


        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //设置响应头通知浏览器以图片的形式打开
        response.setContentType("image/jpeg");
        //设置响应头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        try {
            //将图片写给浏览器
            ImageIO.write(bi, "jpg", response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception ex) {
            log.error("生成图形验证码失败", ex);
            throw new RuntimeException(ex);
        }
    }

    private String getCacheKey(String imageVerifyCodeBizId) {
        return ImageVerifyCodeUtils.getCacheKey(imageVerifyCodeBizId);
    }

    private String newImageVerifyCode(ImageVerifyCodeTypeEnum imageVerifyCodeTypeEnum, int verifyCodeCount) {
        if (imageVerifyCodeTypeEnum.equals(ImageVerifyCodeTypeEnum.NUMBER_AND_CHARACTER)) {
            return RandomStringUtils.random(verifyCodeCount, 0, ALPHA_NUMERIC_ALL_CHAR.length, true, true, ALPHA_NUMERIC_ALL_CHAR);
        } else if (ImageVerifyCodeTypeEnum.CHARACTER.equals(imageVerifyCodeTypeEnum)) {
            return RandomStringUtils.randomAlphabetic(verifyCodeCount);
        } else {
            return RandomStringUtils.randomNumeric(verifyCodeCount);
        }
    }


    /**
     * 设置图片的背景色
     *
     * @param g
     */
    private void setBackGround(Graphics g, Integer width, Integer height) {
        // 设置颜色
        g.setColor(Color.WHITE);
        // 填充区域
        g.fillRect(0, 0, width, height);
    }

    /**
     * 设置图片的边框， 可加可以不加
     *
     * @param g
     */
    private void setBorder(Graphics g) {
        // 设置边框颜色
        //        g.setColor(Color.BLUE);
        //        // 边框区域
        //        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    /**
     * 在图片上画随机线条
     *
     * @param g
     */
    private void drawRandomLine(Graphics g, int width, int height) {
        // 设置颜色
        g.setColor(Color.GREEN);
        // 设置线条个数并画线
        for (int i = 0; i < 7; i++) {
            int x1 = new Random().nextInt(width);
            int y1 = new Random().nextInt(height);
            int x2 = new Random().nextInt(width);
            int y2 = new Random().nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 字体旋转角度
     *
     * @param g
     * @param baseChar
     */
    private void drawChar(Graphics2D g, String baseChar) {
        // 设置颜色
        g.setColor(Color.RED);
        // 设置字体
        g.setFont(new Font("宋体", Font.BOLD, 20));
        StringBuffer sb = new StringBuffer();
        int x = 5;
        String ch = "";
        // 控制字数
        for (int i = 0; i < baseChar.length(); i++) {
            // 设置字体旋转角度
            int degree = new Random().nextInt() % 30;
            ch = baseChar.charAt(i) + "";

            // 正向角度
            g.rotate(degree * Math.PI / 180, x, 20);
            g.drawString(ch, x, 20);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, x, 20);
            x += 18;
        }
    }

}
