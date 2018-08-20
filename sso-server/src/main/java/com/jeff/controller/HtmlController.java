package com.jeff.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangying on 2018/8/20.
 */
@Controller
@RequestMapping("/html")
public class HtmlController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "world333");

        return "template/hello";
    }
}