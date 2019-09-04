package com.jiuyao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackController {

    @RequestMapping("/addSalesman")
    public String  addSalesman(){
        return "salesmanRegister";
    }
}
