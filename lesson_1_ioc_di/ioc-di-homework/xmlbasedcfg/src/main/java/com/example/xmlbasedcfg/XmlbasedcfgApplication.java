package com.example.xmlbasedcfg;

import com.example.xmlbasedcfg.model.FirstBean;
import com.example.xmlbasedcfg.model.PrototypeBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class XmlbasedcfgApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmlbasedcfgApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        FirstBean firstBean = (FirstBean) context.getBean("firstBean");
        System.out.println("Hi, " + firstBean.getName() + "!");
    }

}
