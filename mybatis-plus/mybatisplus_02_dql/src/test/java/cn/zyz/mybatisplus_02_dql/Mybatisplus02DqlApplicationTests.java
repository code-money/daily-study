package cn.zyz.mybatisplus_02_dql;

import cn.zyz.mybatisplus_02_dql.dao.UserDao;
import cn.zyz.mybatisplus_02_dql.entity.User;
import cn.zyz.mybatisplus_02_dql.entity.query.UserQuery;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

    @Autowired
    UserDao userDao;


    //条件构造器Wrapper的使用具体API可以查看官网
    @Test
    void testGetAll() {
        //方式一:按条件查询
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.lt("age",18);
//        List<User> users = userDao.selectList(wrapper);
//        System.out.println(users);


        //方式二：按条件查询,lambda形式
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
//        //10到30岁之间
////        queryWrapper.lt(User::getAge,30).gt(User::getAge,10);
//        //小于10岁或大于30岁
//        queryWrapper.lt(User::getAge,10).or().gt(User::getAge,30);
//        List<User> users = userDao.selectList(queryWrapper);
//        users.forEach(System.out::println);
    }

    @Test
    void testGetNotNull(){
        //模拟页面传递过来的查询数据
        UserQuery uq = new UserQuery();
//        uq.setAge(10);
        uq.setAge2(30);

        //null判定
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
//        if (uq.getAge()!=null){
//            queryWrapper.gt(User::getAge,uq.getAge());
//        }
//        queryWrapper.lt(User::getAge,uq.getAge2());
//        List<User> list = userDao.selectList(queryWrapper);
//        list.forEach(System.out::println);

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        //条件控制参数，当condition为true的时候连接后面的条件，否则不进行判断
        queryWrapper.gt(null!=uq.getAge(),User::getAge,uq.getAge());
        queryWrapper.lt(null!=uq.getAge2(),User::getAge,uq.getAge2());
        List<User> list = userDao.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    void testGetMap(){
        //查询投影，用于字段选择，或者排序分组等功能，具体还是参考官网条件构造器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("count(*) as count,tel");
        wrapper.groupBy("tel");
        List<Map<String, Object>> maps = userDao.selectMaps(wrapper);
        System.out.println(maps);
    }

    @Test
    void testGetByCondition(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //1.条件  eq  等值查询
//        queryWrapper.eq(User::getName,"Jerry").eq(User::getPassword,"jerry");
//        User user= userDao.selectOne(queryWrapper);
//        System.out.println(user);

        //2.条件  between   范围查询
//        queryWrapper.between(User::getAge,10,50);
//        List<User> users = userDao.selectList(queryWrapper);
//        users.forEach(System.out::println);

        //3.条件  like   模糊查询
        queryWrapper.like(User::getName,"J");  //相当于%J%
        //queryWrapper.likeLeft(User::getName,"J");  //相当于%J
        //queryWrapper.likeRight(User::getName,"J"); //相当于J%
        List<User> users = userDao.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
}
