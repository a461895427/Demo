package com.example.demo.controller;

import com.example.demo.bean.Users;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户控制器
 */
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询所有用户
     * offset 当前展示的第一条
     * limit 限制展示的条数
     */
    @GetMapping(value = "/queryUser")
    public String queryUser(HttpServletRequest request) throws JsonProcessingException {
        //当前第几条
        int offset= Integer.parseInt(request.getParameter("offset"));
        //要展示的数据量
        int limit= Integer.parseInt(request.getParameter("limit"));
        //查询所有用户数据
        List<Users> users = userService.queryUserAll(offset,limit);
        //查询所有用户数据数量
        BigDecimal usersSum = userService.queryUserAllSum();
        //返回JSON数据
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(users);
        return "{\"total\":"+usersSum+",\"rows\":"+json+"}";
    }

    @PostMapping(value = "/addUser")
    public void addUser() {

    }

}
