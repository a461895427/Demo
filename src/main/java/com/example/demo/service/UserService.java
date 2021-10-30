package com.example.demo.service;

import com.example.demo.bean.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Rewrite
 */
@Mapper
public interface UserService {
    /**
     * 通过用户名查询用户所有信息
     * @param userName
     * @return
     */
    public Users selectUserByUserName(String userName);
}
