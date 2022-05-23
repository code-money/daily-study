package com.zyz.dao.impl;

import com.zyz.dao.AccountDao;
import org.springframework.stereotype.Component;

/**
 * 账户的持久层实现类
 *
 *     <bean id="accountDao" class="com.zyz.dao.impl.AccountDaoImpl" ></bean>
 */
@Component("accountDao2")
public class AccountDaoImpl2 implements AccountDao {

    public  void saveAccount(){

        System.out.println("保存了账户222222222222222");
    }
}
