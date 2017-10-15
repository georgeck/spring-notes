package com.chiramattel.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.Resource;

@Configuration
public class ApplicationConfig {

    @Bean()
    @Profile("foo")
    @Resource(name = "haha")
    public Component1Impl component1(ApplicationContext context){
        return new Component1Impl(context);
    }
}
