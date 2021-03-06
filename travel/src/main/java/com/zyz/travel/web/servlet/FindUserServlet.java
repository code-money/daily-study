package com.zyz.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从session中获得登陆用户
        Object user =request.getSession().getAttribute("login_user");
        //将user写回客户端
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("text/html;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),user);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
