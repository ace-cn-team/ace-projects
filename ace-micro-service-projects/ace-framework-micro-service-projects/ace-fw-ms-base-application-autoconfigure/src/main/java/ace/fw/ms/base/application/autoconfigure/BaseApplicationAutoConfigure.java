
package ace.fw.ms.base.application.autoconfigure;

import ace.fw.ms.application.autoconfigure.MsApplicationAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;


/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/3 14:39
 * @description
 */
@AutoConfigureAfter({
        MsApplicationAutoConfiguration.class,
})
@EnableDiscoveryClient
@Configuration
public class BaseApplicationAutoConfigure {

}
