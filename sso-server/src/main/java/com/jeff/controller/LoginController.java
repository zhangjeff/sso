package com.jeff.controller;

import com.jeff.IdProvider.IdProvider;
import com.jeff.entity.User;
import com.jeff.service.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangying on 2018/8/28.
 */
@Controller
public class LoginController {

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping("/login")
    public String login(Model model,
                        @RequestParam(value = "backUrl", required = false) String backUrl) {
        model.addAttribute("backUrl", backUrl);
        return "template/login";
    }

    @RequestMapping(value = "/submitLogin", method = {RequestMethod.POST})
    public String submitLogin(Model model,
                              @RequestParam(value = "account") String account,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "backUrl") String backUrl,
                              HttpServletResponse response,
                              HttpServletRequest request) {
        System.out.println("account =" + account);
        System.out.println("password =" + password);


        User user = new User();
        user.setUname(account);

        Cookie cookie = new Cookie("user", account);
        cookie.setMaxAge(360*24*60); //设置一年有效期
        cookie.setPath("/");
        response.addCookie(cookie);

        String token = addToken(user);
        if (!StringUtils.isEmpty(backUrl)) {
            StringBuffer sbf = new StringBuffer("redirect:").append(backUrl);
            if (backUrl.indexOf("?") > 0) {
                sbf.append("&");
            }
            else {
                sbf.append("?");
            }
            sbf.append("token=").append(token);
            return sbf.toString();
        }

        return "template/admin";
    }

    private String addToken(User user){
        String token = IdProvider.createUUIDId();
        tokenManager.addToken(token, user);
        return token;
    }

    @RequestMapping(value = "/rdurl", method = {RequestMethod.GET})
    public String redirectUrl(Model model) {

        return "redirect:http://www.sina.com.cn";
    }

}
