package com.jeff.boot.config;


import com.jeff.model.SessionUser;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

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


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;


//        WebUtils.setSessionAttribute(request, SESSION_USER, sessionUser);
        SessionUser sessionUser = (SessionUser) WebUtils.getSessionAttribute(request, SESSION_USER);
        if (sessionUser != null) {
            String token = request.getParameter("token");
//            SessionUser sesUser = new SessionUser(token, "jeff");
//            WebUtils.setSessionAttribute(request, SESSION_USER, sesUser);
            filterChain.doFilter(servletRequest, servletResponse);
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies){
                if ("user".equals(cookie.getName())) {

                    String token = request.getParameter("token");
                    SessionUser sesUser = new SessionUser(token, "jeff");
                    WebUtils.setSessionAttribute(request, SESSION_USER, sesUser);
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        } else {
            String backUrl = request.getRequestURL().toString();
            httpRes.sendRedirect("http://localhost:9999/demo/login?backUrl=" + backUrl);
        }
    }

    @Override
    public void destroy() {

    }
}
