package com.zyz.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds;
    static {
        try {
            Properties p = new Properties();
            ClassLoader classLoader = DruidUtils.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("db.properties");
            p.load(resourceAsStream);
            ds=DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource dataSource(){
        return ds;
    }

    /**
     *
     * @param statement    sql处理对象
     * @param connection   数据库连接对象
     * @param resultSet    结果集处理对象
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet){
        try {
            if (statement!=null) {
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 重载cose方法
     * @param statement    sql处理对象
     * @param connection   数据库连接对象
     */
    public static void close(Statement statement,Connection connection){
        close(statement,connection,null);
    }
}
