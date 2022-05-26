import com.zyz.config.SpringConfiguration;
import com.zyz.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-25 11:54
 **/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService service;

    @Test
    public void testTransfer(){
        service.transfer("aaa","bbb",100f);
    }

}



