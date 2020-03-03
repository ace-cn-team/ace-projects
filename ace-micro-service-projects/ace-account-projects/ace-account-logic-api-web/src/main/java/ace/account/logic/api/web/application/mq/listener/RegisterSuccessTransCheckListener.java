package ace.account.logic.api.web.application.mq.listener;

import ace.account.base.api.service.AccountIdentityBaseService;
import ace.account.define.base.model.request.ExistsByAccountRequest;
import ace.account.define.mq.model.messagebody.RegisterSuccessMessageBody;
import ace.account.define.mq.topic.AccountTopicEnum;
import ace.fw.mq.enums.MqResponseEnum;
import ace.fw.mq.model.CallbackContext;
import ace.fw.mq.model.Topic;
import ace.fw.mq.producer.TransactionMqCheckListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/3 11:16
 * @description 账号注册成功回查监听者
 */
public class RegisterSuccessTransCheckListener implements TransactionMqCheckListener<RegisterSuccessMessageBody> {
    @Autowired
    private AccountIdentityBaseService accountIdentityBaseService;

    @Override
    public MqResponseEnum check(CallbackContext<RegisterSuccessMessageBody> callbackContext) {
        boolean isExist = accountIdentityBaseService.existsByAccount(
                ExistsByAccountRequest.builder()
                        .account(callbackContext.getMessageBody().getAccount())
                        .accountBizType(callbackContext.getMessageBody().getAccountBizType())
                        .accountType(callbackContext.getMessageBody().getAccountType())
                        .appId(callbackContext.getMessageBody().getAppId())
                        .build()
        ).check();
        if (isExist) {
            return MqResponseEnum.CommitMessage;
        }
        if (callbackContext.getCallbackCount() > 3) {
            return MqResponseEnum.CommitMessage;
        }
        return MqResponseEnum.ReconsumeLater;
    }

    @Override
    public Topic getTopic() {
        return AccountTopicEnum.REGISTER_SUCCESS_TRANS_TOPIC;
    }
}
