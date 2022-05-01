package com.zyz.test;

import com.zyz.entity.User;
import com.zyz.impl.UserDaoImpl;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-01 11:31
 **/

public class Test {
    public static void main(String[] args) {
        UserDaoImpl impl = new UserDaoImpl();
        User admin = impl.login(new User("admin", "123"));
        System.out.println(admin);
    }
}



