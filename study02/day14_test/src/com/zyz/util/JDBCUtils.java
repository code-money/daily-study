package com.zyz.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-01 11:12
 **/

public class JDBCUtils {
    public static DataSource ds;


    static {

        try {
            Properties properties = new Properties();
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static DataSource getDataSource(){
        return ds;
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}



