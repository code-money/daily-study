package com.zyz.service.impl;

import com.zyz.service.AccountService;
import org.springframework.beans.factory.BeanFactory;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("进入service");
    }


    public void  saveAccount(){
        System.out.println("service中的saveaccount执行");
    }

    public void init(){
        System.out.println("对象初始化");
    }

    public void destroy(){
        System.out.println("对象销毁");
    }
}
