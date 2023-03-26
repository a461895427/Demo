package com.example.demo.dao;


import com.example.demo.bean.Users;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author Rewrite
 */
@Repository
public interface UserDAO {
    /**
     * 查询用户所有信息
     *
     * @return Users
     */
    Users findUserAll(Users user);

    /**
     * 查询所有用户数据数量
     */
    BigDecimal queryUserAllSum();

    /**
     * 查询所有用户数据
     * offset 当前展示的第一条
     * limit 限制展示的条数
     */
    List<Users> queryUserAll(int offset, int limit);


    /**
     * 新增用户
     *
     * @param userAddMap
     * @return
     */
    int addUser(HashMap<String, String> userAddMap);
}

