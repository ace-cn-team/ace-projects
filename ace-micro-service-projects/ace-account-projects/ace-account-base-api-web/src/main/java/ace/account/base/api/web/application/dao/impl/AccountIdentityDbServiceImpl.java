package ace.account.base.api.web.application.dao.impl;


import ace.account.base.api.web.application.dao.mapper.AccountIdentityMapper;
import ace.account.base.api.web.application.dao.AccountIdentityDbService;
import ace.account.define.dao.model.entity.AccountIdentity;
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
public class AccountIdentityDbServiceImpl
        extends MybatisPlusDbServiceImpl<AccountIdentity, AccountIdentityMapper>
        implements AccountIdentityDbService {

}
