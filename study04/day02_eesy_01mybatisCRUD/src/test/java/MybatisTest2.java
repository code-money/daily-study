import com.zyz.dao.IUserDao;
import com.zyz.dao.UserDao;
import com.zyz.entity.IUser;
import com.zyz.entity.QueryVo;
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

public class MybatisTest2 {
    @Test
    public void findAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<IUser> all = mapper.findAll();
        for (IUser iuser : all) {
            System.out.println(iuser);
        }
        sqlSession.close();
    }
}



