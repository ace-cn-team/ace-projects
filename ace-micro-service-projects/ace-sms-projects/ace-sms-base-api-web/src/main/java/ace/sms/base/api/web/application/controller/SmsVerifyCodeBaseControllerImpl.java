package ace.sms.base.api.web.application.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.sms.base.api.controller.SmsVerifyCodeBaseController;
import ace.sms.base.api.web.application.biz.smsverifycode.SendBiz;
import ace.sms.base.api.web.application.biz.smsverifycode.SendNumeralVerifyCodeBiz;
import ace.sms.define.base.model.VerifyCodeId;
import ace.sms.define.base.model.request.CheckEqualRequest;
import ace.sms.define.base.model.request.GetVerifyCodeRequest;
import ace.sms.define.base.model.request.SendNumeralVerifyCodeRequest;
import ace.sms.define.base.model.request.SendVerifyCodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@RestController
@Validated
public class SmsVerifyCodeBaseControllerImpl implements SmsVerifyCodeBaseController {

    @Autowired
    private SendBiz sendBiz;
    @Autowired
    private SendNumeralVerifyCodeBiz sendNumeralVerifyCodeBiz;

    @Override
    public GenericResponseExt<Boolean> send(@Valid SendVerifyCodeRequest request) {
        return sendBiz.execute(request);
    }

    @Override
    public GenericResponseExt<Boolean> sendNumeralVerifyCode(@Valid SendNumeralVerifyCodeRequest request) {
        return sendNumeralVerifyCodeBiz.execute(request);
    }

    @Override
    public GenericResponseExt<String> get(@Valid GetVerifyCodeRequest request) {
        return null;
    }

    @Override
    public GenericResponseExt<Boolean> checkEqual(CheckEqualRequest request) {
        return null;
    }

    @Override
    public GenericResponseExt<Boolean> remove(VerifyCodeId request) {
        return null;
    }
}
