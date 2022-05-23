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
     * 获取spring的ioc容器并获取一个新的bean对象
     *
     *
     *   ApplicationContext:  适用场景为单例模式
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要读取到文件之后就立即创建配置文件中的配置对象。
     *   BeanFactory:         适用场景为多例模式
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才创建对象。
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        //    ApplicationContext创建容器
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //    BeanFactory创建容器
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory =new XmlBeanFactory(resource);
        AccountService accountService = beanFactory.getBean("accountService", AccountService.class);


//        AccountService service = context.getBean("accountService", AccountService.class);
//        AccountDao dao = (AccountDao) context.getBean("accountDao");
//
//
//        System.out.println(service);
//        System.out.println(dao);




    }
}
