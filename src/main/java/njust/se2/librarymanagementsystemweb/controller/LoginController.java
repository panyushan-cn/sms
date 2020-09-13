package njust.se2.librarymanagementsystemweb.controller;

import njust.se2.librarymanagementsystemweb.pojo.User;
import njust.se2.librarymanagementsystemweb.result.Result;
import njust.se2.librarymanagementsystemweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登录方法
     * @param requestUser 请求用户对象
     * @param session 网页session
     * @return 状态码 是否运行登录
     */
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (user == null) {
            return new Result(400);
        } else {
            session.setAttribute("user",user);
            return new Result(200);
        }
    }
}
