package ace.account.define.logic.model.response;

import ace.account.define.base.model.response.GetOAuth2TokenResponse;
import ace.account.define.logic.model.OAuth2Token;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
public class RegisterByMobileResponse {
    @ApiModelProperty(value = "token")
    private GetOAuth2TokenResponse token;
}