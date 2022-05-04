package com.zyz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-01 14:18
 **/


@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码
        resp.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = resp.getWriter();
        //2.输出数据
        pw.write("<h1>你好 Response<h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}



