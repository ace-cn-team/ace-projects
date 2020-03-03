package ace.sms.base.api.web.application.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.sms.define.logic.model.request.SendNumberAndCharacterVerifyCodeRequest;
import ace.sms.logic.api.controller.SmsVerifyCodeLogicController;
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
public class SmsVerifyCodeLogicControllerImpl implements SmsVerifyCodeLogicController {

    @Override
    public GenericResponseExt<Boolean> sendNumberAndCharacterVerifyCode(@Valid SendNumberAndCharacterVerifyCodeRequest request) {
        return null;
    }
}
