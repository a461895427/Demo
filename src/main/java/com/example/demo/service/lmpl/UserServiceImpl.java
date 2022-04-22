package com.example.demo.service.lmpl;


import com.example.demo.bean.Users;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Rewrite
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * 通过用户名查询用户所有信息
     *
     */
    @Override
    public Users selectUserByUserName(String userName) {
        Users user = new Users();
        user.setUserName(userName);
        user = userDAO.findUserAll(user);
        return user.getUsername().isEmpty() ? null : user;
    }

    /**
     * 查询所有用户数据数量
     *
     */
    @Override
    public BigDecimal queryUserAllSum() {
        return userDAO.queryUserAllSum();
    }

    /**
     * 查询所有用户数据
     * offset 当前展示的第一条
     * limit 限制展示的条数
     */
    @Override
    public List<Users> queryUserAll(int offset,int limit) {
        return userDAO.queryUserAll(offset,limit);
    }
}