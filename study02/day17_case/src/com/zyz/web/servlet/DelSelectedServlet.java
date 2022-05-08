package com.zyz.web.servlet;

import com.zyz.service.UserService;
import com.zyz.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-06 22:59
 **/

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] uids = req.getParameterValues("uid");
        UserService userService = new UserServiceImpl();
        userService.delSelectedUser(uids);
        resp.sendRedirect(req.getContextPath()+"/userListServlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}



