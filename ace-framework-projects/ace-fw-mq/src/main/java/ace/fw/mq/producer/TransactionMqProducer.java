package ace.fw.mq.producer;

import ace.fw.model.response.GenericResponseExt;
import ace.fw.mq.enums.TransactionStatusEnum;
import ace.fw.mq.model.TransactionMessage;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/2 1:06
 * @description 事务MQ Producer
 */
public interface TransactionMqProducer {
    /**
     * 同步发送事务MQ
     *
     * @param transactionMessage
     * @return code字段 0代表事务半消息发送成功，0以外代码代表事务半消息发送失败
     * data字段 - code字段为0时候代表事务半消息发送成功时候的事务状态
     * data字段 - code字段为0以外时候，永远为{@link TransactionStatusEnum#Unknow}
     */
    GenericResponseExt<TransactionStatusEnum> send(TransactionMessage transactionMessage);
}
