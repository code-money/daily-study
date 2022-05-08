package com.zyz.service;

import com.zyz.entity.PageBean;
import com.zyz.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 根据user和password登陆
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password);

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteUser(String id);

    /**
     * 根据id查找对象
     * @param id
     * @return
     */
    public User findUserById(String id);

    /**
     * 修改对象
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除选中项方法
     * @param uids
     */
    public void delSelectedUser(String[] uids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
