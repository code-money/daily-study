import com.mysql.jdbc.Driver;
import com.zyz.dao.UserDao;
import com.zyz.entity.QueryVo;
import com.zyz.entity.User;
import com.zyz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
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
    public void findUserByVo(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> users =mapper.findUserByVo(queryVo);
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

    /**
     * 根据条件查询
     */
    @Test
    public void findUserByCondition(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User u = new User();
        u.setUsername("老王");
        u.setSex("女");
        List<User> users = mapper.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 根据queryvo中的id集合实现查询用户列表
     */
    @Test
    public void findUserInIds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        QueryVo vo = new QueryVo();
        List vo_ids = new ArrayList();
        vo_ids.add(41);
        vo_ids.add(42);
        vo_ids.add(48);
        vo.setIds(vo_ids);

        List<User> users = mapper.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }

    }
}



