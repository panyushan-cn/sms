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
    UserDao userDao;

    @Test
    public void get(){

    }
}
