package ace.sms.base.api.service;

import ace.fw.model.response.GenericResponseExt;
import ace.sms.define.base.constant.SmsConstants;
import ace.sms.define.base.model.VerifyCodeId;
import ace.sms.define.base.model.request.CheckEqualRequest;
import ace.sms.define.base.model.request.GetVerifyCodeRequest;
import ace.sms.define.base.model.request.SendNumeralVerifyCodeRequest;
import ace.sms.define.base.model.request.SendVerifyCodeRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 12:50
 * @description 短信验证码服务
 */
@FeignClient(value = SmsConstants.BASE_FEIGN_CLIENT_NAME)
@Validated
public interface SmsVerifyCodeBaseService {
    String MODULE_RESTFUL_NAME = "sms-verify-code-base";


    /**
     * 发送验证码
     */
    @ApiOperation(value = "发送验证码")
    @RequestMapping(path = "/send", method = RequestMethod.POST)
    GenericResponseExt<Boolean> send(@Valid @RequestBody SendVerifyCodeRequest request);

    /**
     * 发送数字验证码
     */
    @ApiOperation(value = "发送数字验证码")
    @RequestMapping(path = "/send", method = RequestMethod.POST)
    GenericResponseExt<Boolean> sendNumeralVerifyCode(@Valid @RequestBody SendNumeralVerifyCodeRequest request);

    /**
     * 获取验证码
     *
     * @param request
     * @return 返回验证码
     */
    @ApiOperation(value = "获取验证码")
    @ApiResponse(code = 200, message = "data字段代表验证码,会出现null")
    @RequestMapping(path = "/get", method = RequestMethod.POST)
    GenericResponseExt<String> get(@Valid @RequestBody GetVerifyCodeRequest request);

    /**
     * 验证验证码是否相等
     *
     * @param request
     * @return
     */
    GenericResponseExt<Boolean> checkEqual(CheckEqualRequest request);

    /**
     * 删除验证码
     *
     * @param request
     * @return
     */
    GenericResponseExt<Boolean> remove(VerifyCodeId request);
}
