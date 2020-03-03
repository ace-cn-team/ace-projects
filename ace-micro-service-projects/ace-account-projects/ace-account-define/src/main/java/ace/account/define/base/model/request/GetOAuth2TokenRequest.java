package ace.account.define.base.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/24 2:14
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOAuth2TokenRequest {
    private String grantType;
    private String clientId;
    private String clientSecret;
    private String username;
    private String password;
}
