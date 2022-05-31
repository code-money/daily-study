package com.zyz.controller;

import com.zyz.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-28 21:32
 **/

@Controller
@RequestMapping("/error")
public class ExceptionController{

    @RequestMapping("/testException")
    public String testException()  throws Exception{
        System.out.println("testException执行了");

        try {
            int a = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有用户出错...");
        }


        return "success";
    }
}



