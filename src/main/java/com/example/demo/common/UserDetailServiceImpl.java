package com.example.demo.common;


import com.example.demo.bean.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Rewrite
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    /**
     * 通过用户名判断是否存在用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userService.selectUserByUserName(username);
        if (users == null) {
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        users.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(users.getRoles()));
        return users;
    }
}