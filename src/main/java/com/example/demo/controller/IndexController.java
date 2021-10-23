package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //登录成功之后的首页
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    //用户管理
    @GetMapping("/system/user")
    public String userList(){
        return "user";
    }
    //角色管理
    @GetMapping("/system/role")
    public String roleList(){
        return "role";
    }
    //菜单管理
    @GetMapping("/system/menu")
    public String menuList(){
        return "menu";
    }
    //公共首页
    @GetMapping("/home")
    public String homeList(){
        return "home";
    }

}
