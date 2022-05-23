package com.zyz.factory;

import com.zyz.service.AccountService;
import com.zyz.service.impl.AccountServiceImpl;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-22 17:07
 **/

public class staticFactory {

    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}



