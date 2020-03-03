package ace.sms.define.logic.model.request;

import ace.sms.define.base.model.VerifyCodeId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 14:44
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendNumberAndCharacterVerifyCodeRequest {
    @ApiModelProperty(value = "验证码Id", required = true)
    @NotNull
    @Valid
    private VerifyCodeId verifyCodeId;


    @ApiModelProperty(value = "图形验证码", required = true)
    @NotBlank
    private String imgVerifyCode;
}
