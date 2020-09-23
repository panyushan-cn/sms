package njust.cs1.shortmessagesystemweb.test;

import njust.cs1.shortmessagesystemweb.dao.UserDao;
import njust.cs1.shortmessagesystemweb.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    MessageService messageService =new MessageService();

    @Autowired
    UserDao userDao;

    @Test
    public void get(){

    }
}
