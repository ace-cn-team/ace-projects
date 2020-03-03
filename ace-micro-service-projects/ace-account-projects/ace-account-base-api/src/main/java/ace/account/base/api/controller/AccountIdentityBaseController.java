package ace.account.base.api.controller;

import ace.account.base.api.service.AccountIdentityBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 12:29
 * @description
 */
@RestController
@RequestMapping(path = "/" + AccountIdentityBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface AccountIdentityBaseController extends AccountIdentityBaseService {

}
