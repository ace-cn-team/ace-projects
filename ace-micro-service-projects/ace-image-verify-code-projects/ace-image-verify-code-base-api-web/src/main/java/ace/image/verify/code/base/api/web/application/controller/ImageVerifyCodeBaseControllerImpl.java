package ace.image.verify.code.base.api.web.application.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.image.verify.code.base.api.controller.ImageVerifyCodeBaseController;
import ace.image.verify.code.base.api.web.application.biz.imageverifycode.CheckBiz;
import ace.image.verify.code.base.api.web.application.biz.imageverifycode.GetBiz;
import ace.image.verify.code.define.base.model.request.CheckRequest;
import ace.image.verify.code.define.base.model.request.GetImageVerifyCodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@RestController
@Validated
public class ImageVerifyCodeBaseControllerImpl implements ImageVerifyCodeBaseController {
    @Autowired
    private GetBiz getBiz;
    @Autowired
    private CheckBiz checkBiz;

    @Override
    public void get(@Valid GetImageVerifyCodeRequest request) {
        getBiz.execute(request);
    }

    @Override
    public GenericResponseExt<Boolean> check(@Valid CheckRequest request) {
        checkBiz.execute(request);
        return GenericResponseExtUtils.buildSuccessWithData(true);
    }
}
