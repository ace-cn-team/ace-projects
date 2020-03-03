package ace.account.base.api.service;

import ace.account.define.base.constant.AccountIdentityConstants;
import ace.account.define.base.model.request.ExistsByAccountRequest;
import ace.account.define.base.model.request.ExistsByMobileRequest;
import ace.account.define.dao.model.entity.AccountIdentity;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.restful.base.api.service.AbstractRestfulBaseService;
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
 * @create 2020/1/14 12:29
 * @description
 */
@FeignClient(
        name = AccountIdentityConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "accountIdentityBaseService",
        path = "/" + AccountIdentityBaseService.MODULE_RESTFUL_NAME
)
@Validated
public interface AccountIdentityBaseService extends AbstractRestfulBaseService<AccountIdentity> {
    String MODULE_RESTFUL_NAME = "account-identity-base";

    @ApiOperation(value = "是否存在该手机号码")
    @RequestMapping(path = "/exists-by-mobile", method = RequestMethod.POST)
    GenericResponseExt<Boolean> existsByMobile(@Valid @RequestBody ExistsByMobileRequest request);

    @ApiOperation(value = "是否存在该账号")
    @RequestMapping(path = "/exists-by-account", method = RequestMethod.POST)
    GenericResponseExt<Boolean> existsByAccount(@Valid @RequestBody ExistsByAccountRequest request);


}
