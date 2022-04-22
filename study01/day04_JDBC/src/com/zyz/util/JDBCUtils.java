package com.zyz.util;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {

        try {
            //创建Properties集合类
            Properties p =new Properties();
            //获取类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            //通过类加载器将Properties文件加载到流中
            InputStream stream = classLoader.getResourceAsStream("db.properties");
            //加载Properties文件
            p.load(stream);

            url=p.getProperty("url");
            user=p.getProperty("username");
            password=p.getProperty("password");
            driver=p.getProperty("driver");

            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
    }

    /**
     *
     * @param statement    sql处理对象
     * @param connection   数据库连接对象
     * @param resultSet    结果集处理对象
     */
    public static void close(Statement statement,Connection connection,ResultSet resultSet){
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
