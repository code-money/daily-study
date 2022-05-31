package cn.zyz.controller;

import cn.zyz.entity.Account;
import cn.zyz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-29 15:59
 **/


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("findAll");
        List<Account> all = accountService.findAll();
        model.addAttribute("accounts",all);
        return "list";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("saveAccount");
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }
}



