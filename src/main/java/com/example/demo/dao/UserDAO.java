package com.example.demo.dao;


import com.example.demo.bean.Users;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rewrite
 */
@Repository
public interface UserDAO {
    /**
     * 查询用户所有信息
     *
     * @param user
     * @return Users
     */
    Users findUserAll(Users user);

    /**
     * 查询所有用户
     */
    List<Users> queryUserAll();

}

