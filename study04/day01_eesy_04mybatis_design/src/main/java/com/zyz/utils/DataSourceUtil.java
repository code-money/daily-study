package com.zyz.utils;

import com.zyz.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 11:38
 **/

public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }
}



