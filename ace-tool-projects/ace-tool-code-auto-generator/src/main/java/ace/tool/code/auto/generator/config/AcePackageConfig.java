package ace.tool.code.auto.generator.config;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2019/12/31 18:29
 * @description
 */
@Data
@Accessors(chain = true)
public class AcePackageConfig extends PackageConfig {
    /**
     * ControllerService包名,controller接口类
     */
    private String controllerService = "service";
}
