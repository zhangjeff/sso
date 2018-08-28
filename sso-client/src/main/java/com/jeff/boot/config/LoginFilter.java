package com.jeff.boot.config;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangying on 2018/8/28.
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("aaaaaa");
        System.out.println("bbbbbb");
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;
        httpRes.sendRedirect("http://localhost:9999/demo/login");
       // http://localhost:9999/demo/login
    }

    @Override
    public void destroy() {

    }
}
