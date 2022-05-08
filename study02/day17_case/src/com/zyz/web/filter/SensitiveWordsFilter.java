package com.zyz.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-08 12:43
 **/

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<String>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            //1.获取文件真实路径
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //2.读取文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            //3.读取
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                list.add(line);
            }
            bufferedReader.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SensitiveWordsFilter");

        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")){
                    //增强返回值
                    //获取返回值
                    String value =(String) method.invoke(req,args);
                    if (value!=null){
                        for (String str : list) {
                            if (value.contains(str)){
                                value= value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req,args);
            }
        });
        filterChain.doFilter(proxy_req,resp);
    }

    @Override
    public void destroy() {

    }
}



