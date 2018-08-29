package com.jeff.controller;

import com.jeff.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;

/**
 * Created by zhangying on 2018/8/28.
 */
@Controller
public class LoginController {


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
                              @RequestParam(value = "backUrl") String backUrl) {
        System.out.println("account =" + account);
        System.out.println("password =" + password);

        if (!StringUtils.isEmpty(backUrl)) {
            return "redirect:" + backUrl;
        }
        User user = new User();
        user.setUname(account);

        Cookie cookie = new Cookie("user", account);
        cookie.setMaxAge(360*24*60); //设置一年有效期
        cookie.setPath("/");


//        Cookie cookie = new Cookie("user", user);
//        15         cookie.setMaxAge(360*24*60);//设置一年有效期
//        16         cookie.setPath("/");//可在同一应用服务器内共享方法
//        17         response.addCookie(cookie);//放松到客户段
        return "template/admin";
    }

    @RequestMapping(value = "/rdurl", method = {RequestMethod.GET})
    public String redirectUrl(Model model) {

        return "redirect:http://www.sina.com.cn";
    }

}
