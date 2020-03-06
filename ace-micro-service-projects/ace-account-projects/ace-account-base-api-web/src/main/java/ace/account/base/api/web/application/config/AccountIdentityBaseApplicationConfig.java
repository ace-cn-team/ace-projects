package ace.account.base.api.web.application.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 15:57
 * @description
 */
@Configuration
@MapperScan("ace.account.base.api.web.application.dao.mapper")
public class AccountIdentityBaseApplicationConfig {

}