package com.itheima.utils;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 10:55
 **/

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类
 *   开启事务
 *   提交事务
 *   回滚事务
 *   释放连接
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        System.out.println("before");
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction(){
        System.out.println("after-returning");
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        System.out.println("after-throwing");
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 释放连接
     */
    public void releaseTransaction(){
        System.out.println("after");
        try {
            connectionUtils.getThreadConnection().close();//还回池中
            connectionUtils.removeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}



