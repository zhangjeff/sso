package com.jeff.boot.config;


import com.jeff.api.AuthenticationRpcService;
import com.jeff.model.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import org.thymeleaf.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangying on 2018/8/28.
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class LoginFilter implements Filter {

    public static final String SESSION_USER = "_sessionUser";

    @Autowired
    private AuthenticationRpcService authenticationRpcService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies){
                if ("sso".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }

        SessionUser sessionUser = (SessionUser) WebUtils.getSessionAttribute(request, SESSION_USER);
        if (sessionUser != null  && StringUtils.isEmpty(token)){
            token = sessionUser.getToken();

        }

        if (token != null) {
            boolean flag = authenticationRpcService.validate(token);
            if (!flag) {
                Cookie cookie = new Cookie("sso",null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                httpRes.addCookie(cookie);

                WebUtils.setSessionAttribute(request, SESSION_USER, null);
                String backUrl = request.getRequestURL().toString();
                httpRes.sendRedirect("http://localhost:9999/sso/login?backUrl=" + backUrl);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            token = request.getParameter("token");
            if (token != null) {
                SessionUser sesUser = new SessionUser(token, "jeff");

                WebUtils.setSessionAttribute(request, SESSION_USER, sesUser);
                Cookie cookie = new Cookie("sso", token);
                cookie.setMaxAge(-60); //设置一年有效期
                cookie.setPath("/");
                cookie.setDomain(request.getServerName());
                httpRes.addCookie(cookie);

                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                String backUrl = request.getRequestURL().toString();
                httpRes.sendRedirect("http://localhost:9999/sso/login?backUrl=" + backUrl);
            }
//            token = request.getParameter("token");
//
//            Cookie[] cookies = request.getCookies();
//            if (cookies != null) {
//                for (Cookie cookie : cookies){
//                    if ("user".equals(cookie.getName())) {
//
//
//                    }
//                }
//            } else {
//
//            }
        }
    }

    @Override
    public void destroy() {

    }
}
