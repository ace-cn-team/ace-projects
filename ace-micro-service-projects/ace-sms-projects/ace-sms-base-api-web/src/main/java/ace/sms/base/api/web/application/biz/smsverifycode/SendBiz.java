package ace.sms.base.api.web.application.biz.smsverifycode;

import ace.fw.model.response.GenericResponseExt;
import ace.sms.base.api.web.application.enums.SmsTemplateEnum;
import ace.sms.base.api.web.application.provider.SmsProvider;
import ace.sms.base.api.web.application.provider.model.request.SmsSendRequest;
import ace.sms.define.base.model.request.SendSmsRequest;
import ace.sms.define.base.model.request.SendVerifyCodeRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/25 16:44
 * @description
 */
@Component
@Slf4j
public class SendBiz {
    @Autowired
    private SmsProvider smsProvider;

    public GenericResponseExt<Boolean> execute(@Valid SendVerifyCodeRequest request) {

        Map<String, String> templateContent = new HashMap<>();
        templateContent.put("verifyCode", request.getVerifyCode());
        return smsProvider.send(SmsSendRequest
                .builder()
                .mobile(request.getVerifyCodeId().getMobile())
                .templateId(SmsTemplateEnum.VERIFY_CODE.getCode())
                .templateContent(templateContent)
                .build());
    }
}
