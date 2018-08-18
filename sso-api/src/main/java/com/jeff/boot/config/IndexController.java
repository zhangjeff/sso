package com.jeff.boot.config;

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
}
