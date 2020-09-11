package njust.se2.librarymanagementsystemweb.service;

import njust.se2.librarymanagementsystemweb.dao.UserDao;
import njust.se2.librarymanagementsystemweb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userdao;

    /**
     * 查询是否存在
     * @param username 用户名
     * @return 是否存在 boolean
     */
    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    /**
     * 通过用户名查询对象
     * @param username 用户名
     * @return User对象
     */
    public User getByName(String username) {
        return userdao.findByUsername(username);
    }

    /**
     * 通过用户名密码查询对象
     * @param username 用户名
     * @param password 密码
     * @return User对象
     */
    public User get(String username, String password) {
        return userdao.getByUsernameAndPassword(username, password);
    }

    /**
     * 添加用户
     * @param user 用户对象
     */
    public void add(User user) {
        userdao.save(user);
    }

}
