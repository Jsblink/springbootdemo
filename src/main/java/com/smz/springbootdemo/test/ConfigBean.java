package com.smz.springbootdemo.test;

import com.smz.springbootdemo.domain.SimpleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {
    @Bean(name = "SimpleBean1", initMethod = "simpleBeanInitMethod")
    public SimpleBean configBean1(){
        return new SimpleBean(1,"tom", 12);
    }

    @Bean(name = "SimpleBean2", initMethod = "simpleBeanInitMethod")
    public SimpleBean configBean2(){
        return new SimpleBean(2,"jerry", 12);
    }
}
