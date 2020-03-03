package ace.account.define.base.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/23 14:32
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountIdentityRedis {
    /**
     * AccountIdentity表的Id
     */
    private String AccountIdentityId;
    private AccountIdentityTokenId accountIdentityTokenId;

}
