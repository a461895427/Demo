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
import java.text.SimpleDateFormat;
import java.util.HashMap;
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
        int offset = Integer.parseInt(request.getParameter("offset"));
        //要展示的数据量
        int limit = Integer.parseInt(request.getParameter("limit"));
        //查询所有用户数据
        List<Users> users = userService.queryUserAll(offset, limit);
        //查询所有用户数据数量
        BigDecimal usersSum = userService.queryUserAllSum();
        //返回JSON数据
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(users);
        return "{\"total\":" + usersSum + ",\"rows\":" + json + "}";
    }

    /**
     * 新增用户新增用户
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/addUser")
    public String addUser(HttpServletRequest request) throws JsonProcessingException {
        //Map装载新增用户信息
        HashMap<String, String> userAddMap = new HashMap<>();
        //所有的需要装载的数据
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create_time = sdf.format(System.currentTimeMillis());
        String password = "$2a$10$nNQI9Ij1rU5NG9JFLQphweTOteCX6O211Nysrg2V5rRSGDRmRWtm.";
        //装载数据进Map
        userAddMap.put("userId", userId);
        userAddMap.put("userName", userName);
        userAddMap.put("email", email);
        userAddMap.put("phoneNumber", phoneNumber);
        userAddMap.put("password", password);
        userAddMap.put("create_time", create_time);
        //执行用户新增
        Boolean flag = userService.addUser(userAddMap);
        //返回给前端的信息
        if (!flag) {
            return "[\"msg\":\"新增失败!\"]";
        }
        return "[\"msg:\",\"新增成功!\"]";
    }

}
