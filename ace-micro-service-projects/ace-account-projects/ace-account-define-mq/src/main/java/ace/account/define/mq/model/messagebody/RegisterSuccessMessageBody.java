package ace.account.define.mq.model.messagebody;

import ace.account.define.dao.model.enums.accountidentity.AccountBizTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/3 12:19
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterSuccessMessageBody {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "账号id")
    private String accountId;

    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * {@link ace.account.define.dao.model.enums.accountidentity.AccountTypeEnum}
     */
    @ApiModelProperty(value = "账号类型,0-账号,1-手机号码,2-电子邮件地址")
    private Integer accountType;
    /**
     * {@link AccountBizTypeEnum}
     */
    @ApiModelProperty(value = "账号类型,0-平台,1-客户,2-供应商")
    private Integer accountBizType;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "邀请者推广码")
    private String invitorCode;
    @ApiModelProperty(value = "ip")
    private String ip;
}
