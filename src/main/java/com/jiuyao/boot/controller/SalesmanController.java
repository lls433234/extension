package com.jiuyao.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiuyao.boot.entity.Salesman;
import com.jiuyao.boot.entity.User;
import com.jiuyao.boot.entity.dto.Message;
import com.jiuyao.boot.service.SalesmanService;
import com.jiuyao.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;
    @Autowired
    private UserService userService;

    /**
     * 业务人员注册信息
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String salesmanRegister(Salesman salesman){
        String str = salesmanService.addSalesman(salesman);
        return str;
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


    /**
     * 用户根据推广码进行注册
     */
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    @ResponseBody
    public String userRegister(User user){
        log.info("客户申请数据，{}",user);
        Message message = new Message();
        //用户注册
        if (user != null ) {
           message = userService.userRegister(user, message);
        }else {
            message.setCode("10008");
            message.setMsg("参数传递有误，请重新提交");
        }
        return JSONObject.toJSON(message).toString();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView test(@PathVariable String id){
        System.out.println("aaa");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userRegister");
        mv.addObject("id",id);
        return mv;
    }

}
