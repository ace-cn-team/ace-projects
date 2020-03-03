package ace.account.define.base.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/23 14:42
 * @description
 */
public final class AccountIdentityRedisUtils {
    private final static String REDIS_KEY = "ace:identity:${accountIdentityId}";

    public static String createRedisKey(String accountIdentityId) {
        String[] varKeys = new String[]{"${accountIdentityId}"};
        String[] varValues = new String[]{accountIdentityId};
        return StringUtils.replaceEach(AccountIdentityRedisUtils.REDIS_KEY,
                varKeys,
                varValues);
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.replaceEach(AccountIdentityRedisUtils.REDIS_KEY, new String[]{"${appId}"}, new String[]{"1",}));
    }
}
