package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页面控制器
 * @author Rewrite
 */
@Controller
public class IndexController {
    //登录成功之后的首页
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    //用户管理
    @GetMapping("users-table")
    public String userList() {
        return "system/users-table";
    }

    //角色管理
    @GetMapping("role")
    public String roleList() {
        return "system/role";
    }

    //菜单管理
    @GetMapping("menupermissions")
    public String menuList() {
        return "system/menupermissions";
    }

    //公共首页
    @GetMapping("/home")
    public String homeList() {
        return "home";
    }

    //公共首页
    @GetMapping("/navigation")
    public String navigationList() {
        return "system/navigation";
    }

    //404页面
    @GetMapping("/404")
    public String missingList() {
        return "404";
    }

    //系统配置页面
    @GetMapping("/menu")
    public String systemList() {
        return "system/menu";
    }

    //系统配置页面
    @GetMapping("/cat")
    public String catList() {
        return "cat";
    }
}
