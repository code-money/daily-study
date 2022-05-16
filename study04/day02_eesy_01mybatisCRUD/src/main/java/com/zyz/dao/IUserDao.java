package com.zyz.dao;

import com.zyz.entity.IUser;
import com.zyz.entity.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询全部用户
     * @return
     */
    List<IUser> findAll();
}
