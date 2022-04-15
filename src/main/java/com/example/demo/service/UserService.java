package com.example.demo.service;

import com.example.demo.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rewrite
 */
@Mapper
@Service
public interface UserService {
    /**
     * 通过用户名查询用户所有信息
     *
     * @param userName
     * @return Users
     */
    Users selectUserByUserName(String userName);

    /**
     * 查询所有用户
     */
    List<Users> queryUserAll();
}
