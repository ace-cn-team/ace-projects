package ace.account.base.api.web.application.dao;

import ace.account.define.dao.model.entity.AccountProfile;
import ace.fw.mybatis.plus.extension.service.MybatisPlusDbService;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 账号标识表 服务类
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-02
 */
public interface AccountProfileDbService extends MybatisPlusDbService<AccountProfile> {

}
