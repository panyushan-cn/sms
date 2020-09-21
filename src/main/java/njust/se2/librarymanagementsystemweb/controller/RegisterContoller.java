package njust.se2.librarymanagementsystemweb.controller;

import njust.se2.librarymanagementsystemweb.pojo.User;
import njust.se2.librarymanagementsystemweb.result.Result;
import njust.se2.librarymanagementsystemweb.result.ResultFactory;
import njust.se2.librarymanagementsystemweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterContoller {

    @Autowired
    UserService userService;

//    @CrossOrigin
//    @PostMapping("api/register")
//    @ResponseBody
//    public Result register(@RequestBody User user) {
//        String username = user.getUsername();
//        String password = user.getPassword();
//        username = HtmlUtils.htmlEscape(username);
//        user.setUsername(username);
//
//        boolean exist = userService.isExist(username);
//        if (exist) {
//            String message = "用户名已被使用";
//            return ResultFactory.buildFailResult(message);
//        }
//
//        // 生成盐,默认长度 16 位
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//        // 设置 hash 算法迭代次数
//        int times = 2;
//        // 得到 hash 后的密码
//        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
//        // 存储用户信息，包括 salt 与 hash 后的密码
//        user.setSalt(salt);
//        user.setPassword(encodedPassword);
//        userService.add(user);
//
//        return ResultFactory.buildSuccessResult(user);
//    }
    @CrossOrigin
    @PostMapping("api/register")
    @ResponseBody 
    public Result register(@RequestBody User user) {
        int status = userService.register(user);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
}
