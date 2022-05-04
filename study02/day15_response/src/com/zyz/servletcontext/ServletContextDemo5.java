package com.zyz.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext对象的获取
         */


        //1.通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //2.获取文件的服务器路径


        String btxt = context.getRealPath("/b.txt");
        System.out.println(btxt);

        String ctxt = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(ctxt);

        String atxt = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(atxt);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
