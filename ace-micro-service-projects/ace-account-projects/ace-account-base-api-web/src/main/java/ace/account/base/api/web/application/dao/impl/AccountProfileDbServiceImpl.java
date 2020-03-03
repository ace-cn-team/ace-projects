package ace.account.base.api.web.application.dao.impl;


import ace.account.base.api.web.application.dao.AccountIdentityDbService;
import ace.account.base.api.web.application.dao.AccountProfileDbService;
import ace.account.base.api.web.application.dao.mapper.AccountIdentityMapper;
import ace.account.base.api.web.application.dao.mapper.AccountProfileMapper;
import ace.account.define.dao.model.entity.AccountIdentity;
import ace.account.define.dao.model.entity.AccountProfile;
import ace.fw.mybatis.plus.extension.service.impl.MybatisPlusDbServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号标识表 服务实现类
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-02
 */
@Service
public class AccountProfileDbServiceImpl
        extends MybatisPlusDbServiceImpl<AccountProfile, AccountProfileMapper>
        implements AccountProfileDbService {

}
