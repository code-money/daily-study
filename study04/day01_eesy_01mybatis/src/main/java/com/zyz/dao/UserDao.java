package com.zyz.dao;

import com.zyz.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询全部用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查用户
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);
}
