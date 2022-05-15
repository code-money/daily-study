package com.zyz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-14 21:54
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer Id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}



