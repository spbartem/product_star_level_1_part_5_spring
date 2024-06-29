package com.example.xmlbasedcfg.model;

public class FirstBean {
    private String name;

    public FirstBean(PrototypeBean prototypeBean) {
        System.out.println("Prototype bean first + " + prototypeBean.toString());
        System.out.println("First bean created!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
