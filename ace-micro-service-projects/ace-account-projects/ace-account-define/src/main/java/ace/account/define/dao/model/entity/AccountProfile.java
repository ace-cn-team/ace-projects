package ace.account.define.dao.model.entity;

import ace.fw.data.model.entity.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 账号个人信息表
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AccountProfile", description = "账号个人信息表")
public class AccountProfile implements Serializable, Entity {


    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appid")
    private String appId;

    @ApiModelProperty(value = "账号id")
    private String accountId;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别,0-未知,1-男,2-女")
    private Integer sex;

    @ApiModelProperty(value = "生日")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "头像url")
    private String profilePhotoUrl;

    @ApiModelProperty(value = STATE_REMARK)
    private Integer state;

    @ApiModelProperty(value = "邀请人推广码")
    @TableField("Inviter_code")
    private String inviterCode;

    @ApiModelProperty(value = "过期时间")
    private LocalDateTime expireTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "版本号和乐观锁字段,初始为1，更新自增1")
    @Version
    private Integer rowVersion;


    public static final String ID = "id";

    public static final String APP_ID = "app_id";

    public static final String ACCOUNT_ID = "account_id";

    public static final String REAL_NAME = "real_name";

    public static final String NICK_NAME = "nick_name";

    public static final String SEX = "sex";

    public static final String BIRTHDAY = "birthday";

    public static final String PROFILE_PHOTO_URL = "profile_photo_url";

    public static final String STATE = "state";

    public static final String INVITER_CODE = "Inviter_code";

    public static final String EXPIRE_TIME = "expire_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_TIME = "create_time";

    public static final String ROW_VERSION = "row_version";

    public static final String STATE_REMARK = "状态，0-停用，1-启用，2-锁定，3-过期，4-需修改密码";
}
