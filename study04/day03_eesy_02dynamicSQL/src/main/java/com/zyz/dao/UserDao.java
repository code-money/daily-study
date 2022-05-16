package com.zyz.dao;

import com.zyz.entity.QueryVo;
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
     * 根据vo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据条件查询User
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);


    /**
     * 根据queryvoi中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
