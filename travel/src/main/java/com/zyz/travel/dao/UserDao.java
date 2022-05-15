package com.zyz.travel.dao;

import com.zyz.travel.domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 用户添加功能
     * @param user
     */
    void save(User user);

    /**
     * 根据激活码查询用户对象
     * @return
     */
    User findByCode(String code);

    /**
     * 修改指定用户激活状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernamePassword(String username,String password);
}
