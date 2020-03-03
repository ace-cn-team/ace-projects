package ace.tool.code.auto.generator.engine;

import ace.tool.code.auto.generator.config.AceConstVal;
import ace.tool.code.auto.generator.config.AceGlobalConfig;
import ace.tool.code.auto.generator.config.AceTemplateConfig;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2019/12/31 16:56
 * @description 扩展VelocityTemplateEngine模板引擎类
 * 1.增加生成-微服务对外接口
 */
public class AceVelocityTemplateEngine extends VelocityTemplateEngine {
    /**
     * 输出 java xml 文件
     * 1.增加数据层的接口模板文档
     */
    @Override
    public AbstractTemplateEngine batchOutput() {
        super.batchOutput();
        try {
            List<TableInfo> tableInfoList = getConfigBuilder().getTableInfoList();
            for (TableInfo tableInfo : tableInfoList) {
                Map<String, Object> objectMap = getObjectMap(tableInfo);
                Map<String, String> pathInfo = getConfigBuilder().getPathInfo();
                AceTemplateConfig template = (AceTemplateConfig) getConfigBuilder().getTemplate();
                AceGlobalConfig aceGlobalConfig = (AceGlobalConfig) getConfigBuilder().getGlobalConfig();
                // 自定义内容
                InjectionConfig injectionConfig = getConfigBuilder().getInjectionConfig();
                if (null != injectionConfig) {
                    injectionConfig.initTableMap(tableInfo);
                    objectMap.put("cfg", injectionConfig.getMap());
                    List<FileOutConfig> focList = injectionConfig.getFileOutConfigList();
                    if (CollectionUtils.isNotEmpty(focList)) {
                        for (FileOutConfig foc : focList) {
                            if (isCreate(FileType.OTHER, foc.outputFile(tableInfo))) {
                                writer(objectMap, foc.getTemplatePath(), foc.outputFile(tableInfo));
                            }
                        }
                    }
                }
                // Mp.java
                String entityName = tableInfo.getEntityName();

                // MpController.java
                if (null != getConfigBuilder().getPackageInfo().get(AceConstVal.CONTROLLER_SERVICE) && null != pathInfo.get(AceConstVal.CONTROLLER_SERVICE_PATH)) {

                    String controllerServiceFile = String.format((pathInfo.get(AceConstVal.CONTROLLER_SERVICE_PATH) + File.separator + aceGlobalConfig.getControllerServiceName() + suffixJavaOrKt()), entityName);
                    if (isCreate(FileType.OTHER, controllerServiceFile)) {
                        writer(objectMap, templateFilePath(template.getControllerService()), controllerServiceFile);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("无法创建文件，请检查配置信息！", e);
        }
        return this;
    }
}
