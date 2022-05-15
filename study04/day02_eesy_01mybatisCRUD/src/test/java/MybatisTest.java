import com.zyz.dao.UserDao;
import com.zyz.entity.User;
import com.zyz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 14:07
 **/

public class MybatisTest {
    @Test
    public void findAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void saveUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("张三");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京");
        System.out.println(user);
        mapper.saveUser(user);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(49);
        user.setUsername("李四");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("天津");
        mapper.updateUser(user);

        sqlSession.close();
    }

    @Test
    public void deleteUser(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUser(53,"男");

        sqlSession.close();
    }

    @Test
    public void findById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findById(48);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void findByName(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> list = mapper.findByName("%王%");
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void findTotal(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Integer total = mapper.findTotal();
        System.out.println(total);
        sqlSession.close();
    }
}



