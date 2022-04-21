package com.zyz.jdbc;

import com.zyz.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo04 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);

            String sql1 = "update count set blance=blance-? where id =?";
            String sql2 = "update count set blance=blance+? where id =?";

            statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, 300);
            statement1.setInt(2, 1);

            statement2 = connection.prepareStatement(sql2);
            statement2.setInt(1, 300);
            statement2.setInt(2, 4);

            statement1.executeUpdate();
            int a = 1 / 0;
            statement2.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtils.close(statement1, connection);
        }
    }
}
