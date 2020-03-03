package ace.tool.code.auto.generator.application.service;

import ace.tool.code.auto.generator.engine.AceVelocityTemplateEngine;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2019/12/31 11:55
 * @description 代码自动生成
 */
@Service
public class CodeAutoGeneratorService {


    public void execute(GlobalConfig globalConfig,
                        DataSourceConfig dataSourceConfig,
                        PackageConfig packageConfig,
                        TemplateConfig templateConfig,
                        StrategyConfig strategyConfig) {

        // 代码生成器
        new AceAutoGenerator()
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setTemplate(templateConfig)
                .setStrategy(strategyConfig)
                .setTemplateEngine(new AceVelocityTemplateEngine())
                .execute();

    }
}
