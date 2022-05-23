package com.zyz.service.impl;

import com.zyz.dao.AccountDao;
import com.zyz.dao.impl.AccountDaoImpl;
import com.zyz.service.AccountService;
import org.springframework.beans.factory.BeanFactory;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("进入service");
    }

    private AccountDao accountDao;


    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
