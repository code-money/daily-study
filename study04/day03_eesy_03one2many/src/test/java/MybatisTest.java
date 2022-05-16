import com.zyz.dao.AccountDao;
import com.zyz.dao.UserDao;
import com.zyz.entity.Account;
import com.zyz.entity.User;
import com.zyz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 14:07
 **/

public class MybatisTest {
    @Test
    public void AccountTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> list = mapper.findAll();
        for (Account account : list) {
            System.out.println(account);

        }
        sqlSession.close();
    }

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

}



