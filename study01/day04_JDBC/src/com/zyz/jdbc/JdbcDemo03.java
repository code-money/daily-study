package com.zyz.jdbc;

import com.zyz.jdbc.entity.Count;
import com.zyz.util.JDBCUtils;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcDemo03 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement=null;
        try {
            connection = JDBCUtils.getConnection();
            //设置自动提交为false
            connection.setAutoCommit(false);
//            String sql = "select * from count where name = ?";
            String sql="insert into count values(?,?,?)";
            //获取preparestaemnt对象
            statement = connection.prepareStatement(sql);
            //给?(条件)赋值
            statement.setInt(1,4);
            statement.setString(2,"curry");
            statement.setInt(3,500);
            //执行sql获得结果集
            int i = statement.executeUpdate();
            System.out.println(i);
//            ResultSet resultSet = statement.executeQuery();
//            Count count = new Count();
//            while (resultSet.next()) {
//                count.setId(resultSet.getInt("id"));
//                count.setName(resultSet.getString("name"));
//                count.setBlance(resultSet.getInt("blance"));
//                System.out.println(count);
//            }
            //手动提交
            connection.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(statement, connection);
        }
    }
}
