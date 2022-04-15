package com.example.demo.service.lmpl;


import com.example.demo.bean.Users;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param userName
     * @return
     */
    @Override
    public Users selectUserByUserName(String userName) {
        Users user = new Users();
        user.setUserName(userName);
        user = userDAO.findUserAll(user);
        return user.getUsername().isEmpty() ? null : user;
    }

    /**
     * 用户表查询所有用户
     */
    @Override
    public List<Users>  queryUserAll() {
        List<Users> users = userDAO.queryUserAll();
        return users;
    }
}