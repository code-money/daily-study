package com.zyz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-25 13:02
 **/

public class TransactionConfig {

    @Bean("transactionManager")
    private PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}



