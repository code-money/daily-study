package com.zyz.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-27 17:22
 **/


@Data
public class Account {
    private String username;
    private String password;
    private Integer money;
//    private User user;
    private List<User> list;
    private Map<String,User> map;
}



