package com.zyz.service.impl;

import com.zyz.dao.IAccountDao;
import com.zyz.domain.Account;
import com.zyz.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService{

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }


    @Override
    public void transfer(String sourceName, String targetName, Float money) {
            //执行操作
            //2.1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5.更新转出账户
            accountDao.updateAccount(source);

//            int i = 1/0;

            //2.6.更新转入账户
            accountDao.updateAccount(target);
    }
}
