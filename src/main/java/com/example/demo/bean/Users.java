package com.example.demo.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * 用户对象 users
 * @author Rewrite
 */
@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long user_Id;

    /**
     * 用户账号/用户名
     */
    @Column(name = "username")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "password")
    private String passWord;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号
     */
    @Column(name = "mobile")
    private String mobile;


    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String create_time;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private String modify_time;

    /**
     * 最近访问时间
     */
    @Column(name = "last_login_time")
    private String last_login_time;


    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 用户描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 用户角色(多角色用逗号间隔)
     */
    @Column(name = "roles")
    private String roles;

    /**
     * 实体类中使想要添加表中不存在字段，就要使用@Transient这个注解了。
     */
    @Transient
    private List authorities;

    public void setAuthorities(List authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.passWord;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    /**
     * 账户是否未过期,过期无法验证
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
