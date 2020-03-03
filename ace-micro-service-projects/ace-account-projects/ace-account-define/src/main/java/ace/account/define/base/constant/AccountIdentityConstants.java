package ace.account.define.base.constant;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 17:37
 * @description
 */
public interface AccountIdentityConstants {
    /**
     * 代表注册手机短信业务的业务ID
     */
    String SMS_REGISTER_BY_MOBILE_BIZ_ID = "register:mobile";
    /**
     * 手机号码注册
     */
    String SMS_REGISTER_BY_MOBILE_BIZ_NAME = "手机号码注册";
    /**
     * openfeign扫描微服务api的包路径
     */
    String FEIGN_CLIENT_SERVICE_PACKAGE = "ace.account.base.api.service";
    /**
     * base层微服务openfeign配置名称
     */
    String BASE_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-account-base-api.name:ace-account-base-api-web}";
    /**
     * logic层微服务openfeign配置名称
     */
    String LOGIC_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-account-logic-api.name:ace-account-logic-api-web}";
    /**
     * account-identity-base-api是否开启openfeign注入
     */
    String CONFIG_KEY_ACCOUNT_IDENTITY_BASE_API_ENABLE = "ace.ms.service.account-base-api.enable";

}
