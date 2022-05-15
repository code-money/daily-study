import com.zyz.dao.UserDao;
import com.zyz.entity.User;
import com.zyz.mybatis.io.Resources;
import com.zyz.mybatis.sqlsession.SqlSession;
import com.zyz.mybatis.sqlsession.SqlSessionFactory;
import com.zyz.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义mybatis框架的实现
 * @program: study04
 * @author: zyz
 * @create: 2022-05-14 22:36
 **/

public class MybatisTest {


    @Test
    public void test01() throws IOException {
        //1.读取配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlsessionfactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用工厂生产sqlsession对象
        SqlSessionFactory sqlSessionFactory = builder.build(stream);
        //4.使用sqlsession创建dao接口的代理对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //5.使用代理对象执行方法
        UserDao mapper =  sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {
        //1.读取配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlsessionfactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用工厂生产sqlsession对象
        SqlSessionFactory sqlSessionFactory = builder.build(stream);
        //4.使用sqlsession创建dao接口的代理对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //5.使用代理对象执行方法
        UserDao mapper =  sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
    }


}



