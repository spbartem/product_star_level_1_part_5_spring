package com.example.workshop.model;

import org.springframework.stereotype.Component;

@Component
public class FirstBean {

    private SecondBean secondBean;

    public FirstBean(PrototypeBean prototypeBean) {
        System.out.println("First bean Created!");
        System.out.println("Prototype bean first + " + prototypeBean.toString());
    }

    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }
}
