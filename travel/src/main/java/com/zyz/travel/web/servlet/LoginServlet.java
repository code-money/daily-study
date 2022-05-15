package com.zyz.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyz.travel.domain.ResultInfo;
import com.zyz.travel.domain.User;
import com.zyz.travel.service.UserService;
import com.zyz.travel.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装user对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.调用service查询
        UserService service = new UserServiceImpl();
        User u = service.login(user);  //查询出来的完成用户对象

        //4.判断用户名对象是否为null
        ResultInfo info = new ResultInfo();
        if (u== null){
            //用户名密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        //5.用户是否激活
        if (u != null && !"Y".equals(u.getStatus())){
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活");
        }
        //6.登陆成功
        if (u!=null && "Y".equals(u.getStatus())){
            info.setFlag(true);
            HttpSession session = request.getSession();
            //将登陆了的用户存到session中去
            session.setAttribute("login_user",u);
        }

        //7.响应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("text/html;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
