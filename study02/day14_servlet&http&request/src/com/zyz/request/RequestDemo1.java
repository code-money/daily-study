package com.zyz.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
           一. 获取请求行相关数据的方法

                1. 获取请求方式 ：
					* String getMethod()
				2. (*)获取虚拟目录：
					* String getContextPath()
				3. 获取Servlet路径:
					* String getServletPath()
				4. 获取get方式请求参数：
					* String getQueryString()
				5. (*)获取请求URI：/day14/demo1
					* String getRequestURI():
					* StringBuffer getRequestURL()
				6. 获取协议及版本：HTTP/1.1
					* String getProtocol()
				7. 获取客户机的IP地址：
					* String getRemoteAddr()
         */

        //1.获取请求方式
        String method = request.getMethod();
        System.out.println(method);
        //2.获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.获取Servlet请求路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4.获取请求的参数
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5.获取请求的URI/URL
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //6.获取协议及版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7.获取客户机的ip地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
