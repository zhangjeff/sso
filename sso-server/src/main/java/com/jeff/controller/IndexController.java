package com.jeff.controller;

import com.jeff.api.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Youpeng.Zhang on 2018/8/17.
 */
@RestController
public class IndexController {
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    String index(){
        String name = helloWorldService.getNameById(1);
        return "Hello Spring Boot" + name;
    }
}
