package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 16:10
 **/

public class BeanFactory {

    private IAccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public IAccountService getAccountService() {
        //返回一个代理对象
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    //对方法进行增强，也就是对方法添加事务操作
                    try {
                        System.out.println("进入事务");
                        //1.开启事务
                        txManager.beginTransaction();
                        //2.执行操作
                        Object invoke = method.invoke(accountService, args);
                        //3.提交事务
                        txManager.commitTransaction();
                        //4.返回结果
                        return invoke;
                    } catch (Exception e) {
                        //5.回滚事务
                        txManager.rollbackTransaction();
                        throw new RuntimeException("回滚事务");
                    } finally {
                        //6.释放资源
                        txManager.releaseTransaction();
                    }
                });
    }
}



