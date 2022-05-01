package com.zyz.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

        /*//get获取请求参数
        //根据请求参数获取参数值
        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数

        //1.根据请求参数获取参数值
        String username = request.getParameter("username");
        /*System.out.println("post");
        System.out.println(username);*/

        //2.根据请求参数获取参数值数组
        String[] hobbies = request.getParameterValues("hobby");
        /*for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        //3.获取请求的所有参数
        Enumeration<String> parameterNames = request.getParameterNames();
        /*while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(name+"------"+value);
        }*/

        //4.获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> names= parameterMap.keySet();
        for (String name : names) {
            String[] values = parameterMap.get(name);
            System.out.print(name+":");
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.print("\n");
        }
    }
}
