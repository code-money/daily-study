package com.zyz.mybatis.sqlsession;

public interface SqlSessionFactory {
    /**
     * 用于打开新的sqlsession对象
     * @return
     */
    SqlSession openSession();
}
