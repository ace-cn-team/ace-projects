package ace.account.logic.api.web.application.biz.accountidentity;

import ace.account.define.base.constant.AccountIdentityConstants;
import ace.account.define.logic.model.request.SendVerifyCodeRegisterByMobileRequest;
import ace.fw.model.response.GenericResponseExt;
import ace.sms.base.api.service.SmsVerifyCodeBaseService;
import ace.sms.define.base.model.VerifyCodeId;
import ace.sms.define.base.model.request.SendNumeralVerifyCodeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/25 14:55
 * @description
 */
@Component
@Slf4j
public class SendVerifyCodeRegisterByMobileBiz {
    @Autowired
    private SmsVerifyCodeBaseService smsVerifyCodeBaseService;

    public GenericResponseExt<Boolean> execute(@Valid SendVerifyCodeRegisterByMobileRequest request) {
        GenericResponseExt<Boolean> result = smsVerifyCodeBaseService.sendNumeralVerifyCode(
                SendNumeralVerifyCodeRequest.builder()
                        .bizName(AccountIdentityConstants.SMS_REGISTER_BY_MOBILE_BIZ_NAME)
                        .verifyCodeId(VerifyCodeId.builder()
                                .appId(request.getAppId())
                                .mobile(request.getMobile())
                                .bizId(AccountIdentityConstants.SMS_REGISTER_BY_MOBILE_BIZ_ID)
                                .build())
                        .build()
        );
        result.check();
        return result;
    }
}
