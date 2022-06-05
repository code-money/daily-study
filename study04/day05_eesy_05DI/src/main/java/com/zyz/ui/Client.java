package com.zyz.ui;


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
//        AccountService service = context.getBean("accountService", AccountService.class);
//        service.saveAccount();
//
//        AccountService service2 = context.getBean("accountService2", AccountService.class);
//        service2.saveAccount();
        AccountService service = context.getBean("AccountService3", AccountService.class);
        service.saveAccount();

    }
}
