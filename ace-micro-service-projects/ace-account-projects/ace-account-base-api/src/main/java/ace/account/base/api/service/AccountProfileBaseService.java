package ace.account.base.api.service;

import ace.account.define.base.constant.AccountIdentityConstants;
import ace.account.define.dao.model.entity.AccountProfile;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.restful.base.api.service.AbstractRestfulBaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotBlank;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 12:29
 * @description
 */
@FeignClient(
        name = AccountIdentityConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "accountProfileBaseService",
        path = "/" + AccountProfileBaseService.MODULE_RESTFUL_NAME
)
@Validated
public interface AccountProfileBaseService extends AbstractRestfulBaseService<AccountProfile> {
    String MODULE_RESTFUL_NAME = "account-profile-base";

    @ApiOperation(value = "根据accountId查询账号信息")
    @RequestMapping(path = "/get-by-account-id", method = RequestMethod.POST)
    GenericResponseExt<AccountProfile> getByAccountId(@NotBlank @RequestBody String accountId);

}
