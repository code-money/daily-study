package com.zyz.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("deFilter...");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("initFilter");
    }

    public void destroy() {
        System.out.println("destroyFilter");
    }

}
