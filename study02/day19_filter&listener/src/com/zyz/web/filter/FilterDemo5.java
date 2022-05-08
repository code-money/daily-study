package com.zyz.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//浏览器直接请求资源时，该过滤器被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)

//浏览器转发请求资源时，该过滤器被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)

//可以将拦截属性设为多个值，因为其是一个数组
@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})

public class FilterDemo5 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo5执行");
        chain.doFilter(request, response);
//        response.setCharacterEncoding("utf-8");
        System.out.println("FilterDemo5响应");
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
