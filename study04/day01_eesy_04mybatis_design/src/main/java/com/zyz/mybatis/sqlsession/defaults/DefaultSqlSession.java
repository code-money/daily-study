package com.zyz.mybatis.sqlsession.defaults;

import com.zyz.mybatis.cfg.Configuration;
import com.zyz.mybatis.sqlsession.SqlSession;
import com.zyz.mybatis.sqlsession.proxy.MapperProxy;
import com.zyz.utils.DataSourceUtil;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 11:22
 **/

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn= DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass  dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),conn));
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {

    }
}



