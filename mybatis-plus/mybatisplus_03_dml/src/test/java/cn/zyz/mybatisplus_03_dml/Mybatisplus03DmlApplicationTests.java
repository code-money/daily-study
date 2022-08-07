package cn.zyz.mybatisplus_03_dml;


import cn.zyz.mybatisplus_03_dml.dao.UserDao;
import cn.zyz.mybatisplus_03_dml.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Mybatisplus03DmlApplicationTests {


    @Autowired
    UserDao userDao;

    @Test
    void testInsert() {
        User user = new User();
//        user.setId(667l);
        user.setAge(100);
        user.setName("rose");
        user.setPassword("rose");
        user.setTel("40008208820");
        userDao.insert(user);
    }

    @Test
    void testBatch(){
        /* 多数据删除
        List<Long> list= new ArrayList<>();
        list.add(1549288738163539969l);
        list.add(1549290228911497218l);
        list.add(1549291166552420354l);
        userDao.deleteBatchIds(list);*/

          //多数据查询
        List<Long> list= new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        List<User> users = userDao.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    @Test
    void testDeleteLogic(){
//        userDao.deleteById(1L);
        //逻辑删除后的数据不会被查询到
        List<User> users = userDao.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateLock(){
//        User user = new User();
//        user.setId(3L);
//        user.setName("Jackson");
//        user.setVersion(1);
//        userDao.updateById(user);


        //模拟两个用户修改，当a用户修改后version为4，b用户再去取值version=3就不成立了，所以修改失败
        User user1 = userDao.selectById(3L);
        User user2 = userDao.selectById(3L);

        user1.setName("Jackson aaa");
        userDao.updateById(user1);

        user2.setName("Jackson b");
        userDao.updateById(user2);

    }

}
