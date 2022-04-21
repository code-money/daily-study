package com.zyz.jdbc;

import com.zyz.jdbc.entity.Count;
import com.zyz.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo02 {
    public static void main(String[] args) {
        Connection connection =null;
        try {
            connection= JDBCUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from count";
            ResultSet resultSet = statement.executeQuery(sql);
            Count count=new Count();
            while (resultSet.next()){
                count.setId(resultSet.getInt("id"));
                count.setName(resultSet.getString("name"));
                count.setId(resultSet.getInt("blance"));
                System.out.println(count);
            }

            JDBCUtils.close(statement,connection,resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
