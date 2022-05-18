package com.zyz.dao;

import com.zyz.entity.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    List<Account> findAccountByUid(Integer uid);

}
