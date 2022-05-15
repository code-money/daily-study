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

@WebServlet("/registUserServlet")
public class RegistUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码校验
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //用完就清空验证码
        session.removeAttribute("CHECKCODE_SERVER");

        if (checkcode_server==null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json传回前端
            ObjectMapper mapper = new ObjectMapper();
            String string = mapper.writeValueAsString(info);
            //传回前端
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(string);
            return;
        }


        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service完成注册
        UserService service = new UserServiceImpl();
        boolean flag=service.regist(user);
        //4.响应结果
        ResultInfo info = new ResultInfo();
        if (flag){
            //注册成功
            info.setFlag(true);
        }else {
            //注册失败
            info.setFlag(false);
            response.setContentType("text/html;charset=utf-8");
            info.setErrorMsg("注册失败");
        }
        //将info对象序列化为json传回前端
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(info);

        //将json数据写回客户端
        response.getWriter().write(string);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
