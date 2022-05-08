package com.zyz.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-08 13:42
 **/

public class ContextLoaderListener implements ServletContextListener {
    /**
     * 监听ServletContextEvent对象创建  ServletContext对象服务器启动后自动创建
     * 服务器启动过后自动调用
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();

    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁，当服务器正常关闭后该方法被调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}



