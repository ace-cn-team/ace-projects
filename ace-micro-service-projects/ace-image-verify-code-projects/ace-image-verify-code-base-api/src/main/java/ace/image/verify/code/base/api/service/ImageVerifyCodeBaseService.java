package ace.image.verify.code.base.api.service;

import ace.fw.model.response.GenericResponseExt;
import ace.image.verify.code.define.base.constant.ImageVerifyCodeConstants;
import ace.image.verify.code.define.base.model.request.CheckRequest;
import ace.image.verify.code.define.base.model.request.GetImageVerifyCodeRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description 图形验证码
 */
@FeignClient(
        name = ImageVerifyCodeConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "imageVerifyCodeBaseService",
        path = "/" + ImageVerifyCodeBaseService.MODULE_RESTFUL_NAME
)
@Validated
public interface ImageVerifyCodeBaseService {
    String MODULE_RESTFUL_NAME = "image-verify-code-base";

    @ApiOperation(value = "获取图形验证码图片")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    void get(@Valid GetImageVerifyCodeRequest request);

    @ApiOperation(value = "验证图形验证码")
    @RequestMapping(path = "/check", method = RequestMethod.POST)
    GenericResponseExt<Boolean> check(@Valid @RequestBody CheckRequest request);
}
