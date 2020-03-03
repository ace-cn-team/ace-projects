package ace.account.logic.api.web.application.biz.accountidentity;

import ace.account.base.api.service.AccountIdentityBaseService;
import ace.account.cas.base.api.facade.AccountCasBaseFacadeService;
import ace.account.define.base.constant.AccountIdentityConstants;
import ace.account.define.base.model.request.ExistsByMobileRequest;
import ace.account.define.base.model.response.GetOAuth2TokenResponse;
import ace.account.define.dao.model.entity.AccountIdentity;
import ace.account.define.dao.model.enums.accountidentity.AccountBizTypeEnum;
import ace.account.define.dao.model.enums.accountidentity.AccountTypeEnum;
import ace.account.define.logic.model.request.RegisterByMobileRequest;
import ace.account.define.logic.model.response.RegisterByMobileResponse;
import ace.account.define.mq.model.messagebody.RegisterSuccessMessageBody;
import ace.account.define.mq.topic.AccountTopicEnum;
import ace.account.logic.api.web.application.util.PasswordUtils;
import ace.fw.copier.BeanCopier;
import ace.fw.exception.BusinessException;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.mq.enums.TransactionStatusEnum;
import ace.fw.mq.model.TransactionMessage;
import ace.fw.mq.producer.TransactionMqProducer;
import ace.fw.util.GenericResponseExtUtils;
import ace.fw.utils.web.WebUtils;
import ace.sms.base.api.service.SmsVerifyCodeBaseService;
import ace.sms.define.base.model.VerifyCodeId;
import ace.sms.define.base.model.request.CheckEqualRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/25 14:51
 * @description
 */
@Component
@Slf4j
public class RegisterByMobileBiz {
    @Autowired
    private SmsVerifyCodeBaseService smsVerifyCodeBaseService;
    @Autowired
    private AccountIdentityBaseService accountIdentityBaseService;
    @Autowired
    private AccountCasBaseFacadeService accountCasBaseFacadeService;
    @Autowired
    private PasswordUtils passwordUtils;
    @Autowired
    private TransactionMqProducer transactionMqProducer;
    @Autowired
    private BeanCopier beanCopier;

    public GenericResponseExt<RegisterByMobileResponse> execute(RegisterByMobileRequest request) {
        AccountBizTypeEnum accountBizTypeEnum = AccountBizTypeEnum.resolve(request.getAccountBizType());

        //获得验证码ID
        Boolean isEqualVerifyCode = smsVerifyCodeBaseService.checkEqual(
                CheckEqualRequest.builder()
                        .verifyCode(request.getVerifyCode())
                        .verifyCodeId(
                                VerifyCodeId.builder()
                                        .appId(request.getAppId())
                                        .bizId(AccountIdentityConstants.SMS_REGISTER_BY_MOBILE_BIZ_ID)
                                        .mobile(request.getMobile())
                                        .build()
                        )
                        .build()
        ).check();

        if (isEqualVerifyCode == false) {
            throw new BusinessException("请输入正确的验证码");
        }

        boolean isExistsByMobile = accountIdentityBaseService.existsByMobile(ExistsByMobileRequest.builder()
                .mobile(request.getMobile())
                .appId(request.getAppId())
                .accountBizType(accountBizTypeEnum.getCode())
                .build()
        ).check();

        if (isExistsByMobile) {
            throw new BusinessException("已存在该手机号码账号");
        }

        String salt = passwordUtils.buildSalt();
        String encodePassword = passwordUtils.encode(request.getPassword(), salt);
        // 初始化会员信息
        AccountIdentity accountIdentity = AccountIdentity.builder()
                .id(UUID.randomUUID().toString())
                .account(request.getMobile())
                .accountId(UUID.randomUUID().toString())
                .accountPassword(encodePassword)
                .accountType(AccountTypeEnum.Mobile.getCode())
                .accountBizType(accountBizTypeEnum.getCode())
                .appId(request.getAppId())
                .passwordEncryptionFactor(salt)
                .rowVersion(1L)
                .createTime(LocalDateTime.now())
                .build();

        List<String> tags = Arrays.asList(
                accountIdentity.getAccountType().toString(),
                accountIdentity.getAccountBizType().toString()
        );

        //准备注册成功消息内容
        String ip = WebUtils.getIpAddr();
        RegisterSuccessMessageBody registerSuccessMessageBody = beanCopier.copy(accountIdentity, RegisterSuccessMessageBody.class);
        registerSuccessMessageBody.setIp(ip);

        TransactionStatusEnum transactionStatusEnum = transactionMqProducer.send(TransactionMessage.builder()
                .messageBody(registerSuccessMessageBody)
                .topic(AccountTopicEnum.REGISTER_SUCCESS_TRANS_TOPIC)
                .tags(tags)
                .transactionEvent(() -> {
                    // 保存会员注册信息
                    GenericResponseExt<Boolean> saveResponse = accountIdentityBaseService.save(accountIdentity);
                    boolean isSuccess = saveResponse.check();
                    if (isSuccess == false) {
                        throw new BusinessException("注册失败,请重试");
                    }
                    return TransactionStatusEnum.CommitTransaction;
                })
                .build())
                .check();
        if (Objects.equals(TransactionStatusEnum.CommitTransaction, transactionStatusEnum) == false) {
            throw new BusinessException("系统繁忙,请稍候再试");
        }
        GetOAuth2TokenResponse oauth2Token = accountCasBaseFacadeService.getOAuth2Token(accountIdentity.getId()).check();

        return GenericResponseExtUtils.buildSuccessWithData(RegisterByMobileResponse.builder()
                .token(oauth2Token)
                .build()
        );
    }
}
