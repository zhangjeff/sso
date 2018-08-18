package com.jeff.boot.config;

import com.jeff.boot.config.api.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Youpeng.Zhang on 2018/8/17.
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "Hello Spring Boot";
    }


    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/test")
    public String test() {
        return helloWorldService.sayHello("Spring boot with Hessian.");
    }
}
