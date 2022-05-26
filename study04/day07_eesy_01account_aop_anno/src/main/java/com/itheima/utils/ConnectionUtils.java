package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 10:44
 **/

@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    public Connection getThreadConnection(){

        try {
            //1.先从ThreadLocal获取
            Connection conn=tl.get();
            //2.判断当前线程是否有连接
            if (conn==null){
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn=dataSource.getConnection();
                tl.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeConnection(){
        tl.remove();
    }
}



