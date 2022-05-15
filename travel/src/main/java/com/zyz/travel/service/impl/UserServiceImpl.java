package com.zyz.travel.service.impl;

import com.alibaba.druid.util.JdbcUtils;
import com.zyz.travel.dao.UserDao;
import com.zyz.travel.dao.impl.UserDaoImpl;
import com.zyz.travel.domain.User;
import com.zyz.travel.service.UserService;
import com.zyz.travel.util.MailUtils;
import com.zyz.travel.util.UuidUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

/**
 * @program: travel
 * @author: zyz
 * @create: 2022-05-12 17:32
 **/

public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户
        User byu = dao.findByUsername(user.getUsername());
        //判断byu是否未null
        if (byu != null){
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        //2.1设置激活码
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        //3.激活邮件发送，邮件正文？
        String content ="<a href ='http://localhost:80/travel/activeUserServlet?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");

        dao.save(user);
        return true;
    }

    @Override
    public Boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = dao.findByCode(code);
        if (user!= null){
            //2.调用修改激活状态
            dao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return dao.findByUsernamePassword(user.getUsername(),user.getPassword());
    }
}



