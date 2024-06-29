package com.example.groovybasedcfg.model;

public class FirstBean {
    public FirstBean(PrototypeBean prototypeBean) {
        System.out.println("Prototype bean first + " + prototypeBean.toString());
        System.out.println("First bean created!");
    }

}
