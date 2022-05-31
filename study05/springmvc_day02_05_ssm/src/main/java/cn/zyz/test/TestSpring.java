package cn.zyz.test;

import cn.zyz.dao.AccountDao;
import cn.zyz.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-29 16:10
 **/

public class TestSpring {


    @Test
    public void run1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = context.getBean("accountService", AccountService.class);
        service.findAll();

    }
}



