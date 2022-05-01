package com.zyz.impl;

import com.zyz.dao.UserDao;
import com.zyz.entity.User;
import com.zyz.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-01 11:23
 **/

public class UserDaoImpl implements UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User login(User loginuser) {
        try {
            //1.编写sql
            String sql = "select * from user where username= ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginuser.getUsername(), loginuser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}



