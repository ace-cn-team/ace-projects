package ace.account.logic.api.web.application.controller;

import ace.account.define.logic.model.request.RegisterByMobileRequest;
import ace.account.define.logic.model.request.SendVerifyCodeRegisterByMobileRequest;
import ace.account.define.logic.model.response.RegisterByMobileResponse;
import ace.account.logic.api.controller.AccountIdentityLogicController;
import ace.account.logic.api.web.application.biz.accountidentity.RegisterByMobileBiz;
import ace.account.logic.api.web.application.biz.accountidentity.SendVerifyCodeRegisterByMobileBiz;
import ace.account.define.base.model.request.ExistsByMobileRequest;
import ace.fw.model.response.GenericResponseExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/18 11:57
 * @description
 */
@RestController
public class AccountIdentityLogicControllerImpl implements AccountIdentityLogicController {
    @Autowired
    private RegisterByMobileBiz registerByMobileBiz;
    @Autowired
    private SendVerifyCodeRegisterByMobileBiz sendVerifyCodeRegisterByMobileBiz;

    @Override
    public GenericResponseExt<Boolean> sendVerifyCodeRegisterByMobile(@Valid SendVerifyCodeRegisterByMobileRequest request) {
        return sendVerifyCodeRegisterByMobileBiz.execute(request);
    }

    @Override
    public GenericResponseExt<RegisterByMobileResponse> registerByMobile(@Valid RegisterByMobileRequest request) {
        return registerByMobileBiz.execute(request);
    }


}