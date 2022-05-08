package com.zyz.web.servlet;

import com.zyz.entity.PageBean;
import com.zyz.entity.User;
import com.zyz.service.UserService;
import com.zyz.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-07 11:09
 **/

@WebServlet("/findUserByPage")
public class FindUserByPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = req.getParameter("currentPage"); //当前页码
        String rows = req.getParameter("rows");   //每页显示条数
        Map<String, String[]> condition = req.getParameterMap();

        if (currentPage == null || "".equals(currentPage)){
            currentPage="1";
        }
        if (rows == null || "".equals(rows)){
            rows="5";
        }
        //2.调用service
        UserService userService = new UserServiceImpl();
        PageBean<User> pb = userService.findUserByPage(currentPage, rows,condition);

        //3.将pagebean存入request域
        req.setAttribute("pb",pb);
        req.setAttribute("condition",condition);//将查询条件也存入request
        //4.转发到list.jsp页面
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}



