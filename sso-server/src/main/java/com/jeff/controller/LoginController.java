package com.jeff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangying on 2018/8/28.
 */
@Controller
public class LoginController {


    @RequestMapping("/login")
    public String hello(Model model) {
//        model.addAttribute("name", "world333");

        return "template/login";
    }
}
