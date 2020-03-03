package ace.tool.code.auto.generator.config.builder;

import ace.tool.code.auto.generator.config.AceConstVal;
import ace.tool.code.auto.generator.config.AcePackageConfig;
import ace.tool.code.auto.generator.config.AceTemplateConfig;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2019/12/31 19:04
 * @description
 */
public class AceConfigBuilder extends ConfigBuilder {

    /**
     * 在构造器中处理配置
     *
     * @param packageConfig    包配置
     * @param dataSourceConfig 数据源配置
     * @param strategyConfig   表配置
     * @param template         模板配置
     * @param globalConfig     全局配置
     */
    public AceConfigBuilder(PackageConfig packageConfig, DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, TemplateConfig template, GlobalConfig globalConfig) {
        super(packageConfig, dataSourceConfig, strategyConfig, template, globalConfig);
        handlerPackage((AceTemplateConfig) template, globalConfig.getOutputDir(), (AcePackageConfig) packageConfig);
    }

    /**
     * 处理包配置
     *
     * @param template  TemplateConfig
     * @param outputDir
     * @param config    PackageConfig
     */
    private void handlerPackage(AceTemplateConfig template, String outputDir, AcePackageConfig config) {

        super.getPackageInfo().put(AceConstVal.CONTROLLER_SERVICE, joinPackage(config.getParent(), config.getControllerService()));

        // 生成路径信息
        setPathInfo(super.getPathInfo(), template.getControllerService(), outputDir, AceConstVal.CONTROLLER_SERVICE_PATH, AceConstVal.CONTROLLER_SERVICE);

    }

    private void setPathInfo(Map<String, String> pathInfo, String template, String outputDir, String path, String module) {
        if (StringUtils.isNotBlank(template)) {
            pathInfo.put(path, joinPath(outputDir, super.getPackageInfo().get(module)));
        }
    }

    /**
     * 连接路径字符串
     *
     * @param parentDir   路径常量字符串
     * @param packageName 包名
     * @return 连接后的路径
     */
    private String joinPath(String parentDir, String packageName) {
        if (StringUtils.isBlank(parentDir)) {
            parentDir = System.getProperty(ConstVal.JAVA_TMPDIR);
        }
        if (!StringUtils.endsWith(parentDir, File.separator)) {
            parentDir += File.separator;
        }
        packageName = packageName.replaceAll("\\.", StringPool.BACK_SLASH + File.separator);
        return parentDir + packageName;
    }

    /**
     * 连接父子包名
     *
     * @param parent     父包名
     * @param subPackage 子包名
     * @return 连接后的包名
     */
    protected String joinPackage(String parent, String subPackage) {
        if (StringUtils.isBlank(parent)) {
            return subPackage;
        }
        return parent + StringPool.DOT + subPackage;
    }
}
