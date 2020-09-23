package njust.cs1.shortmessagesystemweb.controller;


import njust.cs1.shortmessagesystemweb.dao.ContactDao;
import njust.cs1.shortmessagesystemweb.pojo.Contact;
import njust.cs1.shortmessagesystemweb.pojo.User;
import njust.cs1.shortmessagesystemweb.result.Result;
import njust.cs1.shortmessagesystemweb.result.ResultFactory;
import njust.cs1.shortmessagesystemweb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @Autowired
    ContactDao contactDao;

    @CrossOrigin
    @GetMapping("/api/user/contact/{loginname}")
    public Result listUsers(@PathVariable("loginname") String loginname) {
        return ResultFactory.buildSuccessResult(contactService.findAllByLoginname(loginname));
    }

    @CrossOrigin
    @PostMapping("api/user/contact/delete")
    public Result delete(@RequestBody Contact contact) throws Exception {
        contactService.deleteById(contact.getId());
        return ResultFactory.buildSuccessResult_p("删除成功", null);
    }

    @CrossOrigin
    @PutMapping("api/user/contact/edit")
    @ResponseBody
    public Result register(@RequestBody Contact contact) {
        int status = contactService.editContact(contact);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult_p("注册成功", null);
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

    @CrossOrigin
    @PostMapping("api/user/contact/register")
    @ResponseBody
    public Result contactRegister(@RequestBody Contact contact) {
        int status = contactService.contactRegister(contact);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult_p("注册成功", null);
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
}
