package com.example.workshop.model;

import org.springframework.stereotype.Component;

@Component
public class SecondBean {

    public SecondBean(PrototypeBean prototypeBean) {
        System.out.println("Second bean Created!");
        System.out.println("Prototype bean second + " + prototypeBean.toString());
    }
}
