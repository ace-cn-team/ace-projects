package ace.tool.code.auto.generator.config;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/2 10:23
 * @description
 */
@Data
@Accessors(chain = true)
public class AceGlobalConfig extends GlobalConfig {
    /**
     * 各层文件名称方式，例如： %sAction 生成 UserAction
     * %s 为占位符
     */
    private String controllerServiceName;
}
