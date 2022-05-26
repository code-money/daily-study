import com.zyz.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 18:21
 **/

public class AopTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountService service = context.getBean("accountService", AccountService.class);
        //3.执行方法，查看是否已增强
        service.saveAccount();
//        service.updateAccount(1);
//        service.deleteAccount();

    }
}



