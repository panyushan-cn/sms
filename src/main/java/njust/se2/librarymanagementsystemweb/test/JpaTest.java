package njust.se2.librarymanagementsystemweb.test;

import njust.se2.librarymanagementsystemweb.dao.UserDao;
import njust.se2.librarymanagementsystemweb.pojo.User;
import njust.se2.librarymanagementsystemweb.service.BookService;
import njust.se2.librarymanagementsystemweb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    BookService bookService=new BookService();

    @Autowired
    UserService userService = new UserService();
    @Autowired
    UserDao userDao;

    @Test
    public void get(){
        User user = new User();
        user.setEmail("123");
        user.setPhone("123");
        user.setUsername("panyushan");
        user.setName("admin");
        user.setPassword("123");
        userService.register(user);
    }
}
