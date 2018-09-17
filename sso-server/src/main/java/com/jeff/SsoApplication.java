package com.jeff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Youpeng.Zhang on 2018/8/17.
 */

//@RestController
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
//@MapperScan("com.jeff.mapper")
@ImportResource(locations= {"classpath:spring/applicationContext-*.xml"})
public class SsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }

}
