package ace.image.verify.code.base.api.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/3 15:21
 * @description
 */
@SpringBootApplication
public class ImageVerifyCodeBaseApiWebApplication {
    public static void main(String[] args) {
      //  System.setProperty("java.awt.headless","true");
        SpringApplication.run(ImageVerifyCodeBaseApiWebApplication.class, args);
    }
}
