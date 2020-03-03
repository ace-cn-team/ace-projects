package ace.image.verify.code.define.base.model.request;

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
 * @create 2020/3/3 11:23
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckRequest {
    @ApiModelProperty(value = "业务ID", required = true)
    @NotBlank
    @Length(max = 36)
    private String imageVerifyCodeBizId;
    @ApiModelProperty(value = "图形验证码", required = true)
    @NotBlank
    private String imageVerifyCode;
}
