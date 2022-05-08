package com.zyz.dao.impl;

import com.zyz.dao.UserDao;
import com.zyz.entity.User;
import com.zyz.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-06 17:05
 **/

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {

        try {
            String sql = "select * from user where username =? and password = ?";
             User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());

    }

    @Override
    public void deleteUser(Integer id) {
        String sql ="delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findUserById(Integer id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义一个模板sql
        String sql ="select count(*) from user where 1=1 ";
        StringBuilder builder = new StringBuilder(sql);
        //2.遍历Map
        Set<String> strings = condition.keySet();
        //定义参数的集合
        ArrayList params = new ArrayList();
        for (String key : strings) {

            //排除分页参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value!=null && !"".equals(value)){
                //有值，拼接sql
                builder.append(" and "+key+" like ?");
                params.add("%"+value+"%");//?条件的值
            }
        }

        System.out.println(builder.toString());
        System.out.println(params);

        return template.queryForObject(builder.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(Integer start, Integer rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1=1 ";
        StringBuilder builder = new StringBuilder(sql);
        //2.遍历Map
        Set<String> strings = condition.keySet();
        //定义参数的集合
        ArrayList params = new ArrayList();
        for (String key : strings) {

            //排除分页参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value!=null && !"".equals(value)){
                //有值，拼接sql
                builder.append(" and "+key+" like ?");
                params.add("%"+value+"%");//?条件的值
            }
        }
        //添加分页查询
        builder.append(" limit ?,? ");
        //添加分页查询参数
        params.add(start);
        params.add(rows);

        System.out.println(builder.toString());
        System.out.println(params);

        List<User> list = template.query(builder.toString(), new BeanPropertyRowMapper<>(User.class),params.toArray());
        return list;
    }
}



