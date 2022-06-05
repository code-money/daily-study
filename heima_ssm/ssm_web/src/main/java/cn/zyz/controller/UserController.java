package cn.zyz.controller;

import cn.zyz.dao.UserDao;
import cn.zyz.entity.Role;
import cn.zyz.entity.UserInfo;
import cn.zyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-02 15:09
 **/

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> list = userService.findAll();
        modelAndView.addObject("userList",list);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }


    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id") String userId){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam("id") String userId){
        //1.根据id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据id查询可以添加的角色
        List<Role> roles= userService.findOtherRole(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roles);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     *
     * @param userId  用户id
     * @param roleIds  可以添加的角色Id
     * @return
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam("userId") String userId,@RequestParam("ids") String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll";
    }


    //从spring-security中获取登陆的user对象，将登陆的对象名返回
    @RequestMapping("/getUserName")
    @ResponseBody
    public String getUserName(Principal principal) throws Exception{
        principal.getName();
        return principal.getName();
    }
}



