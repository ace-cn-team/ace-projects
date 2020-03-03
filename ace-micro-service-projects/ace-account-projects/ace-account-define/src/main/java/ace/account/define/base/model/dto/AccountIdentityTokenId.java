package ace.account.define.base.model.dto;

import ace.account.define.base.constant.AccountIdentityTokenConstants;
import ace.account.define.dao.model.entity.AccountIdentity;
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
 * @create 2020/2/1 15:09
 * @description Token id
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountIdentityTokenId {
    @NotBlank
    @ApiModelProperty(value = "appId", required = true)
    private String appId;
    @NotBlank
    @ApiModelProperty(value = "账号", required = true)
    private String account;
    @NotNull
    @ApiModelProperty(value = AccountIdentity.ACCOUNT_TYPE_REMARK, required = true)
    private Integer accountType;
    @NotNull
    @ApiModelProperty(value = AccountIdentity.ACCOUNT_BIZ_TYPE_REMARK, required = true)
    private Integer accountBizType;
    @NotBlank
    @ApiModelProperty(value = AccountIdentityTokenConstants.TOKEN_SOURCE_REMARK, required = true)
    private String source;

}
