package ace.account.logic.api.service;

import ace.account.define.base.constant.AccountIdentityConstants;
import ace.account.define.logic.model.request.RegisterByMobileRequest;
import ace.account.define.logic.model.request.SendVerifyCodeRegisterByMobileRequest;
import ace.account.define.logic.model.response.RegisterByMobileResponse;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.restful.logic.api.service.AbstractLogicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/18 10:07
 * @description
 */
@FeignClient(
        name = AccountIdentityConstants.LOGIC_FEIGN_CLIENT_NAME,
        contextId = "accountIdentityLogicService",
        path = "/" + AccountIdentityLogicService.MODULE_RESTFUL_NAME
)
@Validated
public interface AccountIdentityLogicService extends AbstractLogicService {
    String MODULE_RESTFUL_NAME = "/account-identity-logic";

    @ApiOperation(value = "发送手机号码注册验证码")
    @RequestMapping(path = "/send-verify-code-register-by-mobile", method = RequestMethod.POST)
    GenericResponseExt<Boolean> sendVerifyCodeRegisterByMobile(@Valid @RequestBody SendVerifyCodeRegisterByMobileRequest request);

    @ApiOperation(value = "根据验证码-手机号码注册")
    @RequestMapping(path = "/register-by-mobile", method = RequestMethod.POST)
    GenericResponseExt<RegisterByMobileResponse> registerByMobile(@Valid @RequestBody RegisterByMobileRequest request);

}
