package ace.account.define.dao.model.enums.accountidentity;

import ace.fw.enums.BaseEnum;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/20 14:21
 * @description
 */
public enum AccountTypeEnum implements BaseEnum<Integer> {
    Account(0, "账号"),
    Mobile(1, "手机号码"),
    Email(2, "电子邮件地址"),

    ;
    @Getter
    private Integer code;
    @Getter
    private String desc;

    AccountTypeEnum(Integer code, String desc) {

        this.code = code;
        this.desc = desc;
    }

}
