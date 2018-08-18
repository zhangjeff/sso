package com.jeff.service;

import com.jeff.boot.config.api.HelloWorldService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangying on 2018/8/17.
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello(String name) {
        return "hello world " + name;
    }

    @Override
    public String sayGoodBye(String name) {
        return "GoodBye" + name;
    }
}
