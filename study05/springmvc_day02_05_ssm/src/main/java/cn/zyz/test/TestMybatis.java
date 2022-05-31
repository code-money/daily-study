package cn.zyz.test;

import cn.zyz.dao.AccountDao;
import cn.zyz.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-29 17:02
 **/

public class TestMybatis {

    @Test
    public void run1() throws IOException {
        InputStream config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(config);
        SqlSession sqlSession = build.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        sqlSession.close();
    }

    @Test
    public void run2() throws IOException {
        InputStream config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(config);
        SqlSession sqlSession = build.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account nacount = new Account();
        nacount.setName("李四");
        nacount.setMoney(200d);
        mapper.saveAccount(nacount);
        sqlSession.commit();
        sqlSession.close();
    }
}



