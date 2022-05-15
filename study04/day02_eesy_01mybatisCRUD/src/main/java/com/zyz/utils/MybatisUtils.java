package com.zyz.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-14 22:58
 **/

public class MybatisUtils {

    private static SqlSessionFactory sessionFactory;

    static {
        InputStream resourceAsStream;
        try {
            //1.加载配置文件
            resourceAsStream= Resources.getResourceAsStream("mybatis-config.xml");
            //2.获取工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return  sessionFactory.openSession(true);  //true代表自动提交事务  默认是不提交
    }
}



