package ace.fw.eureka.application;

import ace.fw.eureka.application.config.EurekaApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/15 10:25
 * @description
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
