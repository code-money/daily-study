package com.zyz.service.impl;

import com.zyz.dao.UserDao;
import com.zyz.dao.impl.UserDaoImpl;
import com.zyz.entity.PageBean;
import com.zyz.entity.User;
import com.zyz.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-06 17:04
 **/

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username,password);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        /*
            调用Integer.valueof()方法将String转为Integer类型
         */
        userDao.deleteUser(Integer.valueOf(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(Integer.valueOf(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        for (String uid : uids) {
           userDao.deleteUser(Integer.valueOf(uid));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition) {
        Integer currentPage_=Integer.valueOf(currentPage);
        Integer rows_=Integer.valueOf(rows);
        //1.创建一个空的pagebean对象
        PageBean<User> pb = new PageBean<>();

        //3.调用dao查询总记录数
        int totalCount=userDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //5.计算总页码
        int totalPage = (totalCount % rows_==0) ? totalCount / rows_ : totalCount / rows_ +1;
        pb.setTotalPage(totalPage);
        //2.设置参数
        //判断分页条件如果当前页码为0那么再点击上一页还是第一页
        if (currentPage_<=0){
            currentPage_=1;
        }
        //判断分页条件如果当前页码为最大页码那么再点击下一页还是最后一页
        if (currentPage_>=totalPage){
            currentPage_=totalPage;
        }
        pb.setCurrentPage(currentPage_);
        pb.setRows(rows_);

        //4.调用dao查询list集合
        //计算开始记录索引
        int start = (currentPage_-1)*rows_;
        //查询分页的记录
        List<User> pageUsers=userDao.findByPage(start,rows_,condition);
        pb.setList(pageUsers);

        return pb;
    }
}



