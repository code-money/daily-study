package com.zyz.dao;

import com.zyz.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询全部用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查user
     * @param id
     * @return
     */
    User findById(Integer id);

}
