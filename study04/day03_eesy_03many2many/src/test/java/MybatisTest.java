import com.zyz.dao.RoleDao;
import com.zyz.dao.UserDao;
import com.zyz.entity.Role;
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

public class MybatisTest {

    @Test
    public void UserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void RoleTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleDao mapper = sqlSession.getMapper(RoleDao.class);
        List<Role> roles = mapper.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }
        sqlSession.close();
    }

}



