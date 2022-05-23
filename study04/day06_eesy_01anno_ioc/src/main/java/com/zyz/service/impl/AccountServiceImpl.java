package com.zyz.service.impl;

import com.zyz.dao.AccountDao;
import com.zyz.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 账户的业务层实现类
 *
 *     <bean id="accountService" class="com.zyz.service.impl.AccountServiceImpl" ></bean>
 */
@Component("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao1")
//    @Qualifier("accountDao2")
    private AccountDao accountDao;


    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
