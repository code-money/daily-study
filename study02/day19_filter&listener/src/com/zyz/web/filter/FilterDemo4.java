package com.zyz.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/index.jsp")  //指定具体资源路径
//@WebFilter("/user/*")  //目录拦截
//@WebFilter("*.jsp")  //后缀拦截
public class FilterDemo4 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo4....");
        chain.doFilter(request, response);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("<h1>FilterDemo4</h1>");
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
