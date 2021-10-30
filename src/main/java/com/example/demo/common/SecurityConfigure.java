package com.example.demo.common;

import com.example.demo.handler.MyAuthenticationFailureHandler;
import com.example.demo.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author Rewrite
 */
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
    @Resource
    private MyAuthenticationSuccessHandler successHandler;
    @Resource
    private MyAuthenticationFailureHandler failureHandler;
    @Autowired
    UserDetailServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //开启formLogin模式
                .formLogin()
                //用户未登录时，访问任何资源都跳转到此路径，登录界面
                .loginPage("/login.html")
                //登陆表单form中action的地址，也就是处理认证请求的路径
                .loginProcessingUrl("/login")
                //默认是username
                .usernameParameter("username")
                //默认是password
                .passwordParameter("password")
                //登录成功跳转处理方法
                .successHandler(successHandler)
                //登录失败跳转处理方法
                .failureHandler(failureHandler)
         //使用and()连接
        .and()
                //配置权限
                .authorizeRequests()
                //用户可以任意访问
                .antMatchers("/login.html", "/login","/css/**","/js/**").permitAll()
                //需要对外暴露的资源路径
                .antMatchers("/home")
                //user角色和admin角色都可以访问
                .hasAnyAuthority("ROLE_user", "ROLE_admin")
                .antMatchers("/system/user", "system/role", "system/menu")
                //admin角色可以访问
                .hasAnyRole("admin")
                //除上面外的所有请求全部需要授权认证
                //authenticated要求在执行该请求时，必须是已经登录状态
                .anyRequest().authenticated()
        .and()
                //禁用跨站csrf攻击防御，否则无法登录成功，主要是阻挡了POST/PUT/DELETE请求等，没阻挡GET请求，暂时用不上
                .csrf().disable();
        //登出系统
        httpSecurity.logout().logoutUrl("/logout");
    }


    /**
     * BCryptPasswordEncoder进行密码加密
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder());
    }


    /**
     * 强制哈希加密实现
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
