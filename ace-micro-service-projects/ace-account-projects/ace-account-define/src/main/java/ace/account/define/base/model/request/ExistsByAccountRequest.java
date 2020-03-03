package ace.account.define.base.model.request;

import ace.account.define.dao.model.enums.accountidentity.AccountTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

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
public class ExistsByAccountRequest {
    @NotBlank
    @ApiModelProperty(value = "appId", required = true)
    private String appId;
    @NotBlank
    @ApiModelProperty(value = "账号", required = true)
    private String account;
    /**
     * {@link AccountTypeEnum}
     */
    @NotBlank
    @ApiModelProperty(value = "账号类型,0-账号,1-手机号码,2-电子邮件地址", required = true)
    private Integer accountType;
    @NotBlank
    @ApiModelProperty(value = "账号业务类型,0-平台,1-客户,2-供应商", required = true)
    private Integer accountBizType;
}
