package com.zyz.dao.impl;

import com.zyz.dao.AccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {

    public AccountDaoImpl() {
        System.out.println("进入dao");
    }

    public  void saveAccount(){

        System.out.println("保存了账户");
    }
}
