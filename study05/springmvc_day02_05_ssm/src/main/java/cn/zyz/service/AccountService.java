package cn.zyz.service;

import cn.zyz.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    public void saveAccount(Account account);

}
