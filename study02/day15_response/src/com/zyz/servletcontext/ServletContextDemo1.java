package com.zyz.servletcontext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext对象的获取
         */

        //1.通过request对象获取
        ServletContext servletContext1 = request.getServletContext();
        //2.通过httpservlet获取
        ServletContext servletContext2 = this.getServletContext();

        System.out.println(servletContext1);
        System.out.println(servletContext2);
        System.out.println(servletContext1==servletContext2);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
