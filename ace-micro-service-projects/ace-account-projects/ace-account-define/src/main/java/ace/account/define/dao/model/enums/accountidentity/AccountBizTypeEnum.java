package ace.account.define.dao.model.enums.accountidentity;

import ace.fw.enums.BaseEnum;
import ace.fw.exception.SystemException;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/20 14:21
 * @description
 */
public enum AccountBizTypeEnum implements BaseEnum<Integer> {
    Account(0, "平台账号"),
    Mobile(1, "客户账号"),
    Email(2, "供应商账号"),

    ;
    @Getter
    private Integer code;
    @Getter
    private String desc;

    AccountBizTypeEnum(Integer code, String desc) {

        this.code = code;
        this.desc = desc;
    }

    public static AccountBizTypeEnum resolve(Integer accountBizType) {
        AccountBizTypeEnum result = Arrays.asList(values())
                .stream()
                .filter(p -> p.getCode().equals(accountBizType))
                .findFirst()
                .orElse(null);
        if (result == null) {
            throw new SystemException("AccountBizTypeEnum,没有对应的code:" + accountBizType);
        }
        return result;
    }
}
