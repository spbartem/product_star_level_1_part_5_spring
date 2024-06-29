package com.example.groovybasedcfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GroovybasedcfgApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroovybasedcfgApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
    }
}
