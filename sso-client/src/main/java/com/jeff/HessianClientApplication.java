package com.jeff;

import com.jeff.api.HelloWorldService;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhangying on 2018/8/18.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={SessionAutoConfiguration.class,DataSourceAutoConfiguration.class})
@ImportResource(locations= {"classpath:spring/applicationContext-*.xml"})
public class HessianClientApplication extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer,ApplicationContextAware{
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(HessianClientApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
