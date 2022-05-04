package com.zyz.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext对象的获取
         */


        //1.通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //获取数据
        Object name = request.getAttribute("name");
        System.out.println(name);
        Object msg = context.getAttribute("msg");
        System.out.println(msg);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
