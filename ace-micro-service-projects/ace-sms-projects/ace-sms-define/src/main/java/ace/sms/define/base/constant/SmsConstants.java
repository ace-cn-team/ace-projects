package ace.sms.define.base.constant;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/4 20:15
 * @description
 */
public interface SmsConstants {
    /**
     * base api layer openfeign微服务配置名称
     */
    String BASE_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-sms-base-api.name:ace-sms-base-api-web}";

    /**
     * logic api layer openfeign微服务配置名称
     */
    String LOGIC_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-sms-logic-api.name:ace-sms-logic-api-web}";
}
