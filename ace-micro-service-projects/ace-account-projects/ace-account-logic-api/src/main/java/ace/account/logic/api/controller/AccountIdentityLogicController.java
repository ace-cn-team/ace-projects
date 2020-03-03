package ace.account.logic.api.controller;

import ace.account.logic.api.service.AccountIdentityLogicService;
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
@RequestMapping(path = "/" + AccountIdentityLogicService.MODULE_RESTFUL_NAME)
@Validated
public interface AccountIdentityLogicController extends AccountIdentityLogicService {

}
