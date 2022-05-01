package com.zyz.servlet;

import com.zyz.entity.User;
import com.zyz.impl.UserDaoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-01 11:37
 **/


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码格式
        req.setCharacterEncoding("utf-8");

        /*//2.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.封装user对象
        User ruser = new User(username,password);*/

        //2.获取所有请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        //3.创建User对象
        User user = new User();
        //4.使用BeanUtils封装
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.userdao的login方法
        UserDaoImpl userDao = new UserDaoImpl();
        User login = userDao.login(user);
        //5.判断user
        if (login==null){
            //登陆失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            //存储数据
            req.setAttribute("user",login);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}



