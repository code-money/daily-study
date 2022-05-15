package com.zyz.dao;

import com.zyz.entity.User;
import com.zyz.mybatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询全部用户
     * @return
     */
    List<User> findAll();

    /**
     * 通过注解实现
     * @return
     */
    @Select("select * from user")
    List<User> findAllUser();

}
