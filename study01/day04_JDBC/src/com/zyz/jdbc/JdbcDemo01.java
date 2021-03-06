package com.zyz.jdbc;

import com.zyz.jdbc.entity.Count;

import java.sql.*;

public class JdbcDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
        //3.定义sql语句
        String sql = "select * from count";
        //4.获得处理对象
        Statement statement = connection.createStatement();
//        String sql = "insert into count values(3,'steven',1000)";
        //5.执行sql并获得处理返回值对象
        ResultSet resultSet = statement.executeQuery(sql);
        Count count=new Count();
        while (resultSet.next()){
            count.setId(resultSet.getInt("id"));
            count.setName(resultSet.getString("name"));
            count.setBlance(resultSet.getInt("blance"));
            System.out.println(count);
        }


        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();


    }
}
