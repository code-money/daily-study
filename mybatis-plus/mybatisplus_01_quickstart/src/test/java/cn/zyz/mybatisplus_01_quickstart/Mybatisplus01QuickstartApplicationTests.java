package cn.zyz.mybatisplus_01_quickstart;

import cn.zyz.mybatisplus_01_quickstart.dao.UserDao;
import cn.zyz.mybatisplus_01_quickstart.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {


    @Autowired
    UserDao userDao;

    @Test
    void testAdd(){
        User user = new User();
        user.setName("程序员");
        user.setAge(12);
        user.setPassword("111");
        user.setTel("4999911");
        int insert = userDao.insert(user);
    }

    @Test
    void testDel(){
        userDao.deleteById(1548607868767338497L);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setName("Tomas");
        user.setAge(18);
        userDao.updateById(user);
    }

    @Test
    void testGetById(){
        User user = userDao.selectById(2L);
        System.out.println(user);
    }

    @Test
    void testGetAll() {
        List<User> users = userDao.selectList(null);
    }

    @Test
    void testGetPage(){
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码值:"+page.getCurrent());
        System.out.println("一共多少页:"+page.getPages());
        System.out.println("数据:"+page.getRecords());
        System.out.println("每页显示条数:"+page.getSize());
        System.out.println("一共多少条数据:"+page.getTotal());
    }

}
