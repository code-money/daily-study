package com.zyz.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取请求的username
        String username = request.getParameter("username");
        Map<String,Object> map = new HashMap<>();


        if ("tom".equals(username)){
            //存在
            map.put("userExsit",true);
            map.put("msg","此用户太受欢迎，请更换");
        }else {
            //不存在
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }

        //将map转为json传回客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
