package ace.account.logic.api.web.application.controller;

import ace.account.base.api.service.AccountIdentityBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/18 11:57
 * @description
 */
@RestController
public class TestController {
//    @Autowired
//    private AccountCasBaseFacadeService accountCasBaseFacadeService;
//    @Autowired
//    private AccountCasBaseService accountCasBaseService;

    @Autowired
    private AccountIdentityBaseService accountIdentityBaseService;

    @PostMapping("/test/a")
    public String a() {
        accountIdentityBaseService.getById("1");
        return "";
    }
}