package com.itheima.utils;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 10:55
 **/

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类
 *   开启事务
 *   提交事务
 *   回滚事务
 *   释放连接
 */

//注意，该版本的spring包的Aop相关注解有问题，@After注解会优先于@AfterRuternning执行，会报错
@Component("transactionManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;


    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}


    /**
     * 开启事务
     */
    @Before("pt1()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
    @AfterReturning("pt1()")
    public void commitTransaction(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 回滚事务
     */
    @AfterThrowing("pt1()")
    public void rollbackTransaction(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 释放连接
     */
    @After("pt1()")
    public void releaseTransaction(){
        try {
            connectionUtils.getThreadConnection().close();//还回池中
            connectionUtils.removeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}



