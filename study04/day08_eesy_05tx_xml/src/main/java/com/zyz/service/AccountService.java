package com.zyz.service;


import com.zyz.domain.Account;

public interface AccountService {
    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 转账
     * @param sourceName  转出账户
     * @param targetName  转入账户
     * @param money  金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
