package com.zyz.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-08 10:54
 **/


//完成登陆验证的过滤器
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        /*
            filter接收的req和resp是从请求过来的HttpServlet类型的request和response
            代码表示为 ServletRequest req = request(这个是传过来的HttpServlet类型的请求)  进行了向上转型
            因为进行了向上转型，所以可以进行强制转换  向下转型
            HttpServletRequest request =(HttpServletRequest) req;
            HttpServletResponse response =(HttpServletResponse) resp;
         */
        //0.强制转换
        HttpServletRequest request =(HttpServletRequest) req;
        HttpServletResponse response =(HttpServletResponse) resp;
        //1.判断是否登陆相关的资源
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") || uri.contains("loginServlet") ||
            uri.contains("/checkCodeServlet") || uri.contains("/css/") ||
            uri.contains("/js/") || uri.contains("/fonts/")){
            //包含,直接放行
            chain.doFilter(req,resp);
        }else {
            //不包含，验证用户是否登陆
            //3.从session获取user
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user!=null){
                //登陆了 放行
                chain.doFilter(req,resp);
            }else {
                //没有登陆
                request.setAttribute("login_msg","请先登陆！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}



