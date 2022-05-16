package com.zyz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 该类用来测试mybaits的映射文件中列名映射的问题
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IUser {
    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String userSex;
    private String userAddress;
}
