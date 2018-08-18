package com.jeff;

import com.jeff.boot.config.api.HelloWorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * Created by zhangying on 2018/8/18.
 */
@SpringBootApplication
public class HessianClientApplication {
    @Bean
    public HessianProxyFactoryBean helloClient() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl("http://localhost:9999/demo/HelloWorldService");
        factory.setServiceInterface(HelloWorldService.class);
        return factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(HessianClientApplication.class, args);
    }

}
