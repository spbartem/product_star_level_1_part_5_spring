package com.example.javabasedcfg.model;

public class SecondBean {
    public SecondBean(PrototypeBean prototypeBean) {
        System.out.println("Prototype bean second + " + prototypeBean.toString());
        System.out.println("Second bean created!");
    }
}
