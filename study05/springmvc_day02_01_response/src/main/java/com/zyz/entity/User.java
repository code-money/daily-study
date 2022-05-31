package com.zyz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-28 13:42
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private Integer age;
}



