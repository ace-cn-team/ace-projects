package ace.tool.code.auto.generator.application.config;

import ace.tool.code.auto.generator.application.support.listener.ApplicationReadyEventListener;
import ace.tool.code.auto.generator.config.AceGlobalConfig;
import ace.tool.code.auto.generator.config.AcePackageConfig;
import ace.tool.code.auto.generator.config.AceTemplateConfig;
import com.baomidou.mybatisplus.generator.config.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2019/12/10 18:30
 * @description 程序所有配置的入口
 */
@Configuration
@ComponentScan("ace.tool.code.auto.generator.application.support")
@ComponentScan("ace.tool.code.auto.generator.application.service")
public class AceWebApplicationConfig {
    private final static String PREFIX = "ace.tool.auto.generator.";

    @Bean
    public ApplicationReadyEventListener generatorApplicationReadyEventListener() {
        return new ApplicationReadyEventListener();
    }

    @Bean
    @ConfigurationProperties(PREFIX + "mybatis.plus.global")
    public AceGlobalConfig globalConfig() {
        return new AceGlobalConfig();
    }

    @Bean
    @ConfigurationProperties(PREFIX + "mybatis.plus.data-source")
    public DataSourceConfig dataSourceConfig() {
        return new DataSourceConfig();
    }

    @Bean
    @ConfigurationProperties(PREFIX + "mybatis.plus.package")
    public AcePackageConfig packageConfig() {
        return new AcePackageConfig();
    }

    @Bean
    @ConfigurationProperties(PREFIX + "mybatis.plus.template")
    public AceTemplateConfig templateConfig() {
        return new AceTemplateConfig();
    }

    @Bean
    @ConfigurationProperties(PREFIX + "mybatis.plus.strategy")
    public StrategyConfig strategyConfig() {
        return new StrategyConfig();
    }

}
