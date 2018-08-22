package com.jeff;


import com.jeff.api.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by zhangying on 2018/2/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void testJuint(){
        System.out.println("zhangyoupeng");
    }

    @Test
    public void testUserService(){

    }

    @Test
    public void testUserServiceById(){
       String name = helloWorldService.getNameById(1);
        System.out.println(name);
    }
}
