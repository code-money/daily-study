package com.zyz.dao;

import com.zyz.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询全部用户
     * @return
     */
    List<User> findAll();

    /**
     * 新增user
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据UserId删除User
     * @param id
     */
    void deleteUser(Integer id,String sex);

    /**
     * 根据id查user
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查看总记录数
     * @return
     */
    Integer findTotal();
}
