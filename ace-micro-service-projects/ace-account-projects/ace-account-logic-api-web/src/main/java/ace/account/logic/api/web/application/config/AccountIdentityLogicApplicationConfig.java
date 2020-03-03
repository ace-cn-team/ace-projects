package ace.account.logic.api.web.application.config;

import ace.fw.ms.logic.application.autoconfigure.LogicApplicationAutoConfigure;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/3 15:21
 * @description
 */
@ImportAutoConfiguration({
        LogicApplicationAutoConfigure.class
})
@Configuration
public class AccountIdentityLogicApplicationConfig {

}
