package com.zyz.dao;

import com.zyz.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username,String password);
    public void addUser(User user);
    public void deleteUser(Integer id);
    public User findUserById(Integer id);
    public void updateUser(User user);
    public int findTotalCount(Map<String, String[]> condition);
    public List<User> findByPage(Integer start, Integer rows, Map<String, String[]> condition);
}
