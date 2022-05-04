package com.zyz.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie c1 = new Cookie("msg","你好");
        //2.设置cookie存活时间
        c1.setMaxAge(30); //持久化到硬盘上，关闭浏览器30s后消失
        c1.setMaxAge(-1);//关闭浏览器删除cookie
        //3.发送cookie
        response.addCookie(c1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
