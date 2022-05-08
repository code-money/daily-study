package com.zyz.web.servlet;

import com.zyz.entity.User;
import com.zyz.service.UserService;
import com.zyz.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-06 16:59
 **/

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用service
        UserService userService = new UserServiceImpl();
        List<User> users = userService.findAll();
        //2.将查询出来的数据存到request域
        req.setAttribute("users",users);
        //3.转发到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}



