package com.zyz.service.impl;

import com.zyz.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 18:01
 **/


@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了个更新"+i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}



