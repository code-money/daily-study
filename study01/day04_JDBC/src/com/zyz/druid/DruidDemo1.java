package com.zyz.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zyz.util.DruidUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        ClassLoader classLoader = DruidDemo1.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("db.properties");
        p.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(p);
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource.getClass().getName());
        System.out.println(connection);
    }
}
