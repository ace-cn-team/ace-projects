package ace.account.define.base.constant;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 17:37
 * @description
 */
public interface AccountCasConstants {

    /**
     * openfeign扫描微服务api的包路径
     */
    String FEIGN_CLIENT_SERVICE_PACKAGE = "ace.account.cas.base.api.service";
    /**
     * openfeign扫描微服务api facade层的包路径
     */
    String FEIGN_CLIENT_FACADE_SERVICE_PACKAGE = "ace.account.cas.base.api.facade";
    /**
     * 微服务openfeign配置名称
     */
    String FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-account-cas-base-api.name:ace-account-cas-base-api-web}";
    /**
     * account-cas-base-api是否开启openfeign注入
     */
    String CONFIG_KEY_ACCOUNT_CAS_BASE_API_ENABLE = "ace.ms.service.account-cas-base-api.enable";

    /**
     * cas oauth2 token 生成默认参数
     */
    String CAS_OAUTH2_GRANT_TYPE_DEFAULT_VALUE = "password";
    String CAS_OAUTH2_PASSWORD_DEFAULT_VALUE = "password";
    String CAS_OAUTH2_CLIENT_ID_DEFAULT_VALUE = "ace-project-client";
    String CAS_OAUTH2_CLIENT_SECRET_DEFAULT_VALUE = "ace-project-client-secret";

}
