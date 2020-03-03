package ace.account.define.dao.model.entity;

import ace.account.define.dao.model.enums.accountidentity.AccountBizTypeEnum;
import ace.account.define.dao.model.enums.accountidentity.AccountTypeEnum;
import ace.fw.data.model.entity.Entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 账号标识表
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AccountIdentity对象", description = "账号标识表")
public class AccountIdentity implements Serializable, Entity {


    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "账号id")
    private String accountId;

    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * {@link AccountTypeEnum}
     */
    @ApiModelProperty(value = AccountIdentity.ACCOUNT_TYPE_REMARK)
    private Integer accountType;
    /**
     * {@link AccountBizTypeEnum}
     */
    @ApiModelProperty(value = AccountIdentity.ACCOUNT_BIZ_TYPE_REMARK)
    private Integer accountBizType;
    @ApiModelProperty(value = "密码")
    private String accountPassword;

    @ApiModelProperty(value = "加密因子")
    private String passwordEncryptionFactor;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "版本号和乐观锁字段,初始为1，更新自增1")
    @Version
    private Long rowVersion;


    public static final String ID = "id";

    public static final String ACCOUNT_ID = "account_id";

    public static final String ACCOUNT = "account";

    public static final String ACCOUNT_TYPE = "account_type";

    public static final String ACCOUNT_PASSWORD = "account_password";

    public static final String TENANT_ID = "tenant_id";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_TIME = "create_time";

    public static final String ROW_VERSION = "row_version";

    public static final String ACCOUNT_BIZ_TYPE_REMARK = "账号类型,0-平台,1-客户,2-供应商";

    public static final String ACCOUNT_TYPE_REMARK = "账号类型,0-账号,1-手机号码,2-电子邮件地址";
}
