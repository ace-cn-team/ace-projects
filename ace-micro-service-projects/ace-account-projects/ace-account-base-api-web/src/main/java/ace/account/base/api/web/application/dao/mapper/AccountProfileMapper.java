package ace.account.base.api.web.application.dao.mapper;

import ace.account.define.dao.model.entity.AccountIdentity;
import ace.account.define.dao.model.entity.AccountProfile;
import ace.fw.mybatis.plus.extension.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 账号标识表 Mapper 接口
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-02
 */
@Mapper
public interface AccountProfileMapper extends BaseMapper<AccountProfile> {

}
