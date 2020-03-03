package ace.account.define.dao.model.enums.accountidentity;

import ace.fw.enums.BaseEnum;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/14 5:49
 * @description 账号来源
 */
public enum AccountSourceTypeEnum implements BaseEnum<String> {
    PC("pc", "电脑浏览器端"),
    MobileH5("mobile", "手机浏览器端"),
    WXPublicAccount("wxpa", "微信公众号"),
    WXSmallApp("wxsa", "微信小程序"),
    IOS("ios", "ios"),
    Android("android", "安卓");
    @Getter
    private String code;
    @Getter
    private String desc;

    AccountSourceTypeEnum(String code, String desc) {

        this.code = code;
        this.desc = desc;
    }

}
