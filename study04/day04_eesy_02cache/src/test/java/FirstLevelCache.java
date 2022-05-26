import com.zyz.dao.UserDao;
import com.zyz.entity.User;
import com.zyz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 14:07
 **/

public class FirstLevelCache {


    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user1 = mapper.findById(41);
        User user2 = mapper.findById(41);

        //查出来的两个对象相同，所以第二次查询是从缓存中拿出的，并且根据日志可以看出只执行了一次sql语句
        System.out.println(user1==user2);

    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user1 = mapper.findById(41);
        //关闭sqlSession对象
        sqlSession.close();
        //重新开启一个新的sqlSession对象
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UserDao mapper1 = sqlSession1.getMapper(UserDao.class);

        User user2 = mapper1.findById(41);

        //此时的结果为false，说明缓存存在于sqlSession中，关闭消失
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



