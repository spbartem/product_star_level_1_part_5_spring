package com.example.groovybasedcfg

import com.example.groovybasedcfg.model.FirstBean
import com.example.groovybasedcfg.model.PrototypeBean
import com.example.groovybasedcfg.model.SecondBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    FirstBean firstBean(PrototypeBean firstPototypeBean) {
        new FirstBean(firstPototypeBean)
    }

    @Bean
    SecondBean secondBean(PrototypeBean secondPrototypeBean) {
        new SecondBean(secondPrototypeBean)
    }
}