package com.zyz.mybatis.sqlsession;

import com.zyz.mybatis.cfg.Configuration;
import com.zyz.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.zyz.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 10:48
 **/

public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}



