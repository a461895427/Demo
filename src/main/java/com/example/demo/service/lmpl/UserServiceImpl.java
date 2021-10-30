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
    @Autowired
    private UserDAO userDAO;

    /**
     * 通过用户名查询用户所有信息
     * @param userName
     * @return
     */
    @Override
    public Users selectUserByUserName(String userName) {
        Users user = new Users();
        user.setUserName(userName);
        List list = userDAO.findUserAll(user);
        return list.isEmpty() ? null : (Users) list.get(0);
    }
}