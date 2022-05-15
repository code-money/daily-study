package com.zyz.travel.web.servlet;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zyz.travel.service.UserService;
import com.zyz.travel.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取激活码
        String code = request.getParameter("code");
        if (code!=null){
            //2.调用service完成激活
            UserService service = new UserServiceImpl();
            Boolean flag=service.active(code);

            //3.判断标记
            String msg;
            if (flag){
                msg = "激活成功,请<a href = 'login.html'>登录</a>";
            }else {
                msg ="激活失败，联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
