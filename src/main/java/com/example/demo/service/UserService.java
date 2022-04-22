package com.example.demo.service;

import com.example.demo.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
     * @return Users
     */
    Users selectUserByUserName(String userName);

    /**
     *  查询所有用户数据数量
     */
    BigDecimal queryUserAllSum();

    /**
     *  查询所有用户数据
     *  offset 当前展示的第一条
     *  limit 限制展示的条数
     */
    List<Users> queryUserAll(int offset,int limit);
}
