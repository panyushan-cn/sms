package njust.se2.librarymanagementsystemweb.dao;

import njust.se2.librarymanagementsystemweb.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findById(int id);

    User getByUsernameAndPassword(String username, String password);

    User findByUsernameAndPasswordEquals(String username,String password);


}

