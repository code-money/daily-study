package cn.zyz.service.impl;

import cn.zyz.dao.AccountDao;
import cn.zyz.entity.Account;
import cn.zyz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-29 15:58
 **/

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层，查询所有账户");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层，保存账户");
        accountDao.saveAccount(account);
//        int i = 1/0;
    }
}



