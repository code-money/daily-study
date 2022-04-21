package com.zyz.druid;

import com.zyz.util.DruidUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidDemo2 {
    public static int id;
    public static String name;
    public static int blance;
    public static void main(String[] args) throws SQLException {
        Connection connection = DruidUtils.getConnection();
        String sql ="insert into count values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,5);
        statement.setString(2,"rouse");
        statement.setInt(3,700);
        int i = statement.executeUpdate();
        System.out.println(i);
        DruidUtils.close(statement,connection);
    }


    @Test
    public void test2() throws Exception{
        Connection connection = DruidUtils.getConnection();
        String sql ="select * from count where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,5);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            id=resultSet.getInt("id");
            name=resultSet.getString("name");
            blance=resultSet.getInt("blance");
            System.out.println(id+name+blance);
        }
        DruidUtils.close(statement,connection,resultSet);
    }
}
