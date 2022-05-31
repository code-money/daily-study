package com.zyz.controller;

import com.zyz.entity.Account;
import com.zyz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-27 17:15
 **/


@Controller
@RequestMapping("/param")
public class ParamController {


    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        Integer integer = new Integer(100);

        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 原生API获取
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        return "success";
    }


}



