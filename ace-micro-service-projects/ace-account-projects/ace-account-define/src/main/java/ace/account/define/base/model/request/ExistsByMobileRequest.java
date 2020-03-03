package ace.account.define.base.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 18:35
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExistsByMobileRequest {
    @NotBlank
    @ApiModelProperty(value = "appId", required = true)
    private String appId;

    @NotBlank
    @ApiModelProperty(value = "手机号码", required = true)
    private String mobile;
    @NotNull
    @ApiModelProperty(value = "账号业务类型,0-平台,1-客户,2-供应商", required = true)
    private Integer accountBizType;
}
