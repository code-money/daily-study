package com.zyz.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo2执行了");
        chain.doFilter(request, response);
        System.out.println("filterDemo2回来了");
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
