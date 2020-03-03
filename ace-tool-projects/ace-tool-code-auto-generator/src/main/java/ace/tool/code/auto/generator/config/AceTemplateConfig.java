package ace.tool.code.auto.generator.config;

import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2019/12/31 18:16
 * @description
 */
@Data
@Accessors(chain = true)
public class AceTemplateConfig extends TemplateConfig {
    private String controllerService = "/templates/ControllerService.java";
}
