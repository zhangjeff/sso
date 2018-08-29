package com.jeff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

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
        String user = account + password;

        return "template/admin";
    }

    @RequestMapping(value = "/rdurl", method = {RequestMethod.GET})
    public String redirectUrl(Model model) {

        return "redirect:http://www.sina.com.cn";
    }

}
