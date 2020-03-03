package ace.account.base.api.client.autoconfigure;

import ace.account.base.api.controller.AccountIdentityBaseController;
import ace.account.define.base.constant.AccountIdentityConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/5 1:20
 * @description
 */
@ConditionalOnProperty(
        name = AccountIdentityConstants.CONFIG_KEY_ACCOUNT_IDENTITY_BASE_API_ENABLE,
        havingValue = "true",
        matchIfMissing = true
)
@ConditionalOnMissingBean({AccountIdentityBaseController.class})
@ConditionalOnBean(annotation = {EnableFeignClients.class})
@EnableFeignClients(basePackages = {AccountIdentityConstants.FEIGN_CLIENT_SERVICE_PACKAGE})
@Configuration
public class EnableFeignClientAutoConfigure {

}
