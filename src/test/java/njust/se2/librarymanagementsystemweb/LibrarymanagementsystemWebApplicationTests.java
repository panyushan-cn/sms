package njust.se2.librarymanagementsystemweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//@SpringBootTest
//class LibrarymanagementsystemWebApplicationTests {
//
//    @Test
//    void contextLoads() {
//
//    }
//
//}

@RunWith(SpringRunner.class)

@SpringBootTest
@Component
public class LibrarymanagementsystemWebApplicationTests {
    @Autowired
    DataSource datasource;
    @Test
    public void contextLoads() {
        Connection conn;
        try {
            conn = datasource.getConnection();
            System.err.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
