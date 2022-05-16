package com.zyz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-14 21:54
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    User {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;
    private List<Account> accounts;
}



