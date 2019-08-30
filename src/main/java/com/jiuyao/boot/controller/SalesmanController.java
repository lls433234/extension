package com.jiuyao.boot.controller;

import com.jiuyao.boot.entity.Salesman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SalesmanController {

    /**
     * 业务人员注册信息
     */
    @RequestMapping("/salesman/register")
    public void salesmanRegister(Salesman salesman){

        System.out.println(salesman);

    }


    /**
     * 回显所有业务员信息
     */
    @RequestMapping("/salesman/getAll")
    public List<Salesman> getAll(){

        System.out.println("aaa");

        return null;
    }

    /**
     * 根据推广码删除业务员
     */
    @RequestMapping("/salesman/delete")
    public void delete(String salesmanId){

        System.out.println("aaa");

    }

}
