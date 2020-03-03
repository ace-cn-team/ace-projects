package ace.account.define.logic.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/25 14:57
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendVerifyCodeRegisterByMobileRequest {
    /**
     * 应用ID
     */
    @ApiModelProperty(value = "appId", required = true)
    @NotBlank
    @Length(min = 1, max = 36)
    private String appId;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", required = true)
    @NotBlank
    private String mobile;
}
