package ace.account.base.api.web.application.controller;

import ace.account.base.api.web.application.dao.AccountIdentityDbService;
import ace.account.base.api.controller.AccountIdentityBaseController;
import ace.account.define.base.model.request.ExistsByAccountRequest;
import ace.account.define.base.model.request.ExistsByMobileRequest;
import ace.account.define.dao.model.entity.AccountIdentity;
import ace.account.define.dao.model.enums.accountidentity.AccountBizTypeEnum;
import ace.account.define.dao.model.enums.accountidentity.AccountTypeEnum;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.restful.base.api.web.AbstractRestfulController;
import ace.fw.util.AceEnumUtils;
import ace.fw.util.GenericResponseExtUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/17 15:21
 * @description
 */
@RestController
public class AccountIdentityBaseControllerImpl
        extends AbstractRestfulController<AccountIdentity, AccountIdentityDbService>
        implements AccountIdentityBaseController {


    @Override
    public GenericResponseExt<Boolean> existsByMobile(@Valid @RequestBody ExistsByMobileRequest request) {
        LambdaQueryChainWrapper<AccountIdentity> queryChainWrapper = this.getDbService()
                .lambdaQuery()
                .select(AccountIdentity::getId)
                .eq(AccountIdentity::getAccount, request.getMobile())
                .eq(AccountIdentity::getAppId, request.getAppId())
                .eq(AccountIdentity::getAccountType, AccountTypeEnum.Mobile.getCode());

        AccountIdentity accountIdentity = queryChainWrapper.one();

        return GenericResponseExtUtils.buildSuccessWithData(accountIdentity != null && StringUtils.isNotBlank(accountIdentity.getAccountId()));
    }

    @Override
    public GenericResponseExt<Boolean> existsByAccount(@Valid ExistsByAccountRequest request) {
        AccountTypeEnum accountTypeEnum = AceEnumUtils.getEnum(AccountTypeEnum.class, request.getAccountType());
        AccountBizTypeEnum accountBizTypeEnum = AceEnumUtils.getEnum(AccountBizTypeEnum.class, request.getAccountBizType());
        LambdaQueryChainWrapper<AccountIdentity> queryChainWrapper = this.getDbService()
                .lambdaQuery()
                .select(AccountIdentity::getId)
                .eq(AccountIdentity::getAccount, request.getAccount())
                .eq(AccountIdentity::getAppId, request.getAppId())
                .eq(AccountIdentity::getAccountType, accountTypeEnum.getCode())
                .eq(AccountIdentity::getAccountBizType, accountBizTypeEnum.getCode());

        AccountIdentity accountIdentity = queryChainWrapper.one();

        return GenericResponseExtUtils.buildSuccessWithData(accountIdentity != null && StringUtils.isNotBlank(accountIdentity.getAccountId()));

    }
}
