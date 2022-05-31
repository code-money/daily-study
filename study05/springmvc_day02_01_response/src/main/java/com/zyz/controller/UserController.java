package com.zyz.controller;

import com.zyz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.DriverManager;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-28 13:35
 **/

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("执行了");
        //模拟从数据库中查询出一个数据库对象
        User user = new User("张三","13",13);
        model.addAttribute("user",user);
        return "success";
    }


    @RequestMapping("/testVoid")
    public void testVoid(){
        System.out.println("testVoid执行");
    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView");
        ModelAndView mv = new ModelAndView();
        User user = new User("张三","13",13);
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }


    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }


//    @ResponseBody
    @RequestMapping("/testAjax")
    public  User testAjax(@RequestBody User user){
        System.out.println("testAjax");
        //哭护短发送ajax请求，传送的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        user.setUsername("李四");
        user.setAge(100);
        //做响应,添加@ResponseBody注解用于返回json类型数据
        return user;
    }
}



