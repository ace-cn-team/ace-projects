package ace.tool.code.auto.generator.application.service;

import ace.tool.code.auto.generator.config.builder.AceConfigBuilder;
import ace.tool.code.auto.generator.engine.AceVelocityTemplateEngine;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2019/12/31 19:04
 * @description
 */
@Slf4j
public class AceAutoGenerator extends AutoGenerator {
    /**
     * 生成代码
     */
    public void execute() {

        log.debug("==========================准备生成文件...==========================");
        AbstractTemplateEngine templateEngine = super.getTemplateEngine();
        PackageConfig packageInfo = super.getPackageInfo();
        DataSourceConfig dataSource = super.getDataSource();
        StrategyConfig strategy = super.getStrategy();
        TemplateConfig template = super.getTemplate();
        GlobalConfig globalConfig = super.getGlobalConfig();
        // 初始化配置
        if (null == config) {
            config = new AceConfigBuilder(packageInfo, dataSource, strategy, template, globalConfig);
            if (null != injectionConfig) {
                injectionConfig.setConfig(config);
            }
        }

        if (null == templateEngine) {
            // 为了兼容之前逻辑，采用 Velocity 引擎 【 默认 】
            templateEngine = new AceVelocityTemplateEngine();
        }
        // 模板引擎初始化执行文件输出
        templateEngine.init(this.pretreatmentConfigBuilder(config)).mkdirs().batchOutput().open();
        log.debug("==========================文件生成完成！！！==========================");
    }
}
