package ace.account.define.logic.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/18 11:16
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterByMobileRequest {
    @ApiModelProperty(value = "应用Id", required = true)
    @NotBlank
    @Length(min = 1, max = 36)
    private String appId;
    @ApiModelProperty(value = "账号业务类型,0-平台,1-客户,2-供应商", required = true)
    @NotNull
    private Integer accountBizType;
    @ApiModelProperty(value = "手机号码", required = true)
    @NotBlank
    @Length(min = 1, max = 36)
    private String mobile;
    @ApiModelProperty(value = "密码", required = true)
    @NotNull
    @Length(min = 1, max = 36)
    private String password;
    @ApiModelProperty(value = "短信验证码", required = true)
    @NotBlank(message = "请输入短信验证码")
    @Length(min = 6, max = 6)
    private String verifyCode;
    @ApiModelProperty(value = "邀请者推广码", required = false)
    private String invitorCode;
}