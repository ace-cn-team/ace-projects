package ace.account.base.api.web.application.controller;

import ace.account.base.api.controller.AccountProfileBaseController;

import ace.account.base.api.web.application.dao.AccountProfileDbService;
import ace.account.define.dao.model.entity.AccountProfile;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.restful.base.api.web.AbstractRestfulController;
import ace.fw.util.GenericResponseExtUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/17 15:21
 * @description
 */
@RestController
public class AccountProfileBaseControllerImpl
        extends AbstractRestfulController<AccountProfile, AccountProfileDbService>
        implements AccountProfileBaseController {

    @Override
    public GenericResponseExt<AccountProfile> getByAccountId(@NotBlank String accountId) {
        AccountProfile accountProfile = this.getDbService().lambdaQuery()
                .eq(AccountProfile::getAccountId, accountId)
                .one();

        return GenericResponseExtUtils.buildSuccessWithData(accountProfile);
    }
}
