package ace.account.define.mq.topic;

import ace.fw.mq.model.Topic;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/2 19:49
 * @description
 */
public enum AccountTopicEnum implements Topic {
    REGISTER_SUCCESS_TRANS_TOPIC("register_success_trans", "账户注册成功事务主题"),
    REGISTER_SUCCESS_TOPIC("register_success", "账户注册成功主题"),
    ;
    @Getter
    private String code;
    @Getter
    private String desc;

    AccountTopicEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}