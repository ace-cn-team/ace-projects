package ace.account.define.base.model.request;

import ace.account.define.base.model.dto.AccountIdentityTokenId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/1 15:09
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenBuildRequest {
    @NotNull
    @ApiModelProperty(value = "token id", required = true)
    @Valid
    private AccountIdentityTokenId accountIdentityTokenId;
}
