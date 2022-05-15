package com.zyz.mybatis.sqlsession.defaults;

import com.zyz.mybatis.cfg.Configuration;
import com.zyz.mybatis.sqlsession.SqlSession;
import com.zyz.mybatis.sqlsession.SqlSessionFactory;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 11:19
 * SqlSessionFactory实现类
 **/

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}



