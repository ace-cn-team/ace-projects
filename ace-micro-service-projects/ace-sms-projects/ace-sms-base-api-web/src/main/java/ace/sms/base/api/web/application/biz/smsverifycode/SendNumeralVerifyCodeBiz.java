package ace.sms.base.api.web.application.biz.smsverifycode;

import ace.fw.model.response.GenericResponseExt;
import ace.sms.define.base.model.request.SendNumeralVerifyCodeRequest;
import ace.sms.define.base.model.request.SendVerifyCodeRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 14:20
 * @description
 */
@Component
@Slf4j
public class SendNumeralVerifyCodeBiz {
    @Autowired
    private SendBiz sendBiz;

    public GenericResponseExt<Boolean> execute(@Valid SendNumeralVerifyCodeRequest request) {
        String verifyCode = RandomStringUtils.randomNumeric(6);
        return sendBiz.execute(SendVerifyCodeRequest.builder()
                .bizName(request.getBizName())
                .verifyCode(verifyCode)
                .verifyCodeId(request.getVerifyCodeId())
                .build());

    }
}
