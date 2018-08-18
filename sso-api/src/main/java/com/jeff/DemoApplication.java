package com.jeff;

import com.jeff.boot.config.api.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Youpeng.Zhang on 2018/8/17.
 */

@RestController
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
public class DemoApplication {
    @Autowired
    private HelloWorldService helloWorldService;


    @RequestMapping("/index")
    String index(){
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    //发布服务
    @Bean(name = "/HelloWorldService")
    public HessianServiceExporter accountService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(helloWorldService);
        exporter.setServiceInterface(HelloWorldService.class);
        return exporter;
    }
}
