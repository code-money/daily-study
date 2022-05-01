package com.zyz.servlet;

import com.zyz.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getAttribute("user");
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //输出
        response.getWriter().write("登陆成功!"+user.getUsername()+"欢迎您");
        System.out.println("用户名:"+user);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
