package ace.sms.base.api.web.application.config;

import ace.sms.base.api.web.application.provider.LogSmsProvider;
import ace.sms.base.api.web.application.provider.SmsProvider;
import ace.sms.base.api.web.application.provider.impl.taobao.properties.TaobaoClientSmsConfigProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 15:57
 * @description
 */
@Configuration
public class SmsBaseApiWebApplicationConfig {
}
