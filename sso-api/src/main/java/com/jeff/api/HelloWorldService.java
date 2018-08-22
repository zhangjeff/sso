package com.jeff.api;

/**
 * Created by zhangying on 2018/8/17.
 */
public interface HelloWorldService {

    String sayHello(String name);

    String sayGoodBye(String name);

    String getNameById(Integer id);
}
