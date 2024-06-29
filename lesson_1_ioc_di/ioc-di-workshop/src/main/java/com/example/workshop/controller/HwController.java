package com.example.workshop.controller;

import com.example.workshop.model.RequestScopeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HwController {
    private RequestScopeBean requestScopeBean;

    public HwController(RequestScopeBean requestScopeBean) {
        this.requestScopeBean = requestScopeBean;
    }

    @GetMapping("/")
    public String HW() {
        StringBuilder b = new StringBuilder();
        b.append("HW!\n\n");
        b.append("First call of the request scoped bean: \n");
        b.append(requestScopeBean.toString());
        b.append("\n\n");
        b.append("Second call of the request scoped bean: \n");
        b.append(requestScopeBean.toString());
        b.append("\n");
        return b.toString();
    }
}
