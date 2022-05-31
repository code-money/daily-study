package com.zyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-26 23:41
 **/


@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

}



