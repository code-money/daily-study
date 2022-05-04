package com.zyz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-01 14:18
 **/


@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//1.设置状态码
        resp.setStatus(302);
        //2.设置响应头location
        resp.setHeader("location","/day15/responseDemo2");*/

        resp.sendRedirect("/day15/responseDemo2");
//        resp.sendRedirect("http://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}



