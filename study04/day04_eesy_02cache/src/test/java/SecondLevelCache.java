import com.mysql.jdbc.Driver;
import com.zyz.dao.UserDao;
import com.zyz.entity.User;
import com.zyz.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 14:07
 **/

public class SecondLevelCache {

    /**
     * 测试二级缓存
     */
    @Test
    public void testSecondLevelCache1() throws IOException {

        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UserDao mapper1 = sqlSession1.getMapper(UserDao.class);
        User user1 = mapper1.findById(41);
        System.out.println(user1);
        sqlSession1.close();

        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserDao mapper2 = sqlSession2.getMapper(UserDao.class);
        User user2 = mapper2.findById(41);
        System.out.println(mapper2);
        sqlSession2.close();



        //查出来的两个对象相同，所以第二次查询是从缓存中拿出的，并且根据日志可以看出只执行了一次sql语句
        System.out.println(user1==user2);

    }


    /**
     * 测试清空缓存
     */
    @Test
    public void testClearCache3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //1.根据id查询用户
        User user1 = mapper.findById(57);
        System.out.println(user1);

        //2.更新用户信息
        user1.setUsername("张三三");
        user1.setAddress("北京市海淀区");
        mapper.updateUser(user1);

        //3.再次查询id为57的用户
        User user2 = mapper.findById(57);
        System.out.println(user2);

        //此时为false，在进行更改删除添加等操作后，会更新缓存，
        System.out.println(user1==user2);
    }
}



