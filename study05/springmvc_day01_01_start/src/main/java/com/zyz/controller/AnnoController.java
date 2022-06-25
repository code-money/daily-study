package com.zyz.controller;

import com.zyz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-27 19:14
 **/

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //将msg存到session域中
public class AnnoController {


    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String name){
        System.out.println("执行了");
        System.out.println(name);
        return "success";
    }


    /**
     * requestBody注解,将对象封装为请求体，封装后的格式为(例)：username=1&age=1
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable
     * @param id
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable("sid") String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }


    /**
     * ModelAttribute
     * @return
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }
    /**
     * 该方法优先于请求执行
     */
    @ModelAttribute
    public User showUser(String uname){   //uname是根据请求传递的参数获得的
        System.out.println(uname);
        System.out.println("showUser执行了");
        //数据库通过传递过来的uname进行查询(模拟)
        User user = new User();
        user.setUname("张三");
        user.setAge(13);
        user.setDate(new Date());
        return user;  //这里返回的user会存到requestScope域中
    }


    /**
     * SessionAttributes
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes");
        model.addAttribute("msg", "喜羊羊");
        return "success";
    }


    /**
     * 获取session对象
     * @param model
     * @return
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap model){
        System.out.println("getSessionAttributes");
        String msg =(String) model.get("msg");
        System.out.println(msg);
        return "success";
    }
}



