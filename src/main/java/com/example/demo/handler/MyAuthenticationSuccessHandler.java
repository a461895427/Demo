package com.example.demo.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Rewrite
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final RedirectStrategy REDIRECT_STRATEGY = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("{\"code\":\"20001\",\"msg\":\"登录成功\"}");
        //重定向到菜单
        REDIRECT_STRATEGY.sendRedirect(request, response, "/menu");
    }
}
