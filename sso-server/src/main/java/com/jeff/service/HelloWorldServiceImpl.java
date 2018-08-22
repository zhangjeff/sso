package com.jeff.service;

import com.jeff.api.HelloWorldService;
import com.jeff.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangying on 2018/8/17.
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String sayHello(String name) {
        return "hello world " + name;
    }

    @Override
    public String sayGoodBye(String name) {
        return "GoodBye" + name;
    }

    @Override
    public String getNameById(Integer id) {
        return userMapper.selectByPrimaryKey(id).getUname();
    }
}
