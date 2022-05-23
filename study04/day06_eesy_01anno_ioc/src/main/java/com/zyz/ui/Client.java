package com.zyz.ui;

import com.zyz.dao.AccountDao;
import com.zyz.service.AccountService;
import com.zyz.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("1111");
        AccountService service = context.getBean("accountService", AccountService.class);
        System.out.println(service);

        service.saveAccount();


    }
}
