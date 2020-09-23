package njust.cs1.shortmessagesystemweb.controller;

import njust.cs1.shortmessagesystemweb.pojo.AdminMenu;
import njust.cs1.shortmessagesystemweb.result.Result;
import njust.cs1.shortmessagesystemweb.result.ResultFactory;
import njust.cs1.shortmessagesystemweb.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;

//    @GetMapping("/api/menu")
//    public Result menu() {
//        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByCurrentUser());
//    }

    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        return adminMenuService.getMenusByCurrentUser();
    }

    @GetMapping("/api/admin/role/menu")
    public Result listAllMenus() {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByRoleId(1));
    }
}
