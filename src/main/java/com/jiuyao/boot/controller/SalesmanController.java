package com.jiuyao.boot.controller;

import com.jiuyao.boot.entity.Salesman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SalesmanController {

    /**
     * 业务人员注册信息
     */
    @RequestMapping("/salesman/register")
    public void salesmanRegister(Salesman salesman){

        System.out.println(salesman);

    }
}
