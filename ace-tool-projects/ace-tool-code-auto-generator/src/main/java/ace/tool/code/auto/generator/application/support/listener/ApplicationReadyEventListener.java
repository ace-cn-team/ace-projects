package ace.tool.code.auto.generator.application.support.listener;

import ace.tool.code.auto.generator.application.service.CodeAutoGeneratorService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈志杭
 * @contract 279397942@qq.com
 * @create 2019/9/6 10:03
 * @description 监听服务是否启动成功, 并输出注册的bean
 */
@Slf4j
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private CodeAutoGeneratorService codeAutoGeneratorService;
    @Autowired
    private GlobalConfig globalConfig;
    @Autowired
    private DataSourceConfig dataSourceConfig;
    @Autowired
    private PackageConfig packageConfig;
    @Autowired
    private TemplateConfig templateConfig;
    @Autowired
    private StrategyConfig strategyConfig;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        codeAutoGeneratorService.execute(globalConfig, dataSourceConfig, packageConfig, templateConfig, strategyConfig);
    }
}
