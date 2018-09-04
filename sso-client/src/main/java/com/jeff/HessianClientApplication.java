package com.jeff;

import com.jeff.api.HelloWorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * Created by zhangying on 2018/8/18.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource(locations= {"classpath:spring/applicationContext-bean.xml"})
public class HessianClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HessianClientApplication.class, args);
    }

}
