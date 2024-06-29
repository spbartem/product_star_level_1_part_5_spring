package com.example.javabasedcfg;

import com.example.javabasedcfg.model.PrototypeBean;
import com.example.javabasedcfg.model.SecondBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SecondBean secondBean(PrototypeBean prototypeBean) {
        return new SecondBean(prototypeBean);
    }
}
