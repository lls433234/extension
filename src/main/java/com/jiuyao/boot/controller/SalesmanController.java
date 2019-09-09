package com.jiuyao.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiuyao.boot.entity.PublicUser;
import com.jiuyao.boot.entity.Salesman;
import com.jiuyao.boot.entity.User;
import com.jiuyao.boot.entity.dto.Message;
import com.jiuyao.boot.entity.dto.MessageEnum;
import com.jiuyao.boot.service.PublicUserService;
import com.jiuyao.boot.service.SalesmanService;
import com.jiuyao.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;
    @Autowired
    private UserService userService;
    @Autowired
    private PublicUserService publicUserService;

    /**
     * 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView salesmanLogin(Salesman salesman){
        ModelAndView mv = new ModelAndView();
        log.info("登录开始执行,=========={}",salesman);
        HashMap<String, String> map = new HashMap<>();
        map.put("salesmanName",salesman.getSalesmanName());
        map.put("salesmanPassword",salesman.getSalesmanPassword());
        Salesman one = salesmanService.getOne(map);
        if (one == null){//查询记录为空
            log.info("登录失败");
            mv.setViewName("index");
        }else {
            log.info("登录成功");
            if (one.getType().equals("1")){
                mv.setViewName("home");
                mv.addObject("name",one.getName());
            }else {
                mv.setViewName("home2");
                mv.addObject("salesmanName",one.getName());
                mv.addObject("salesmanExtensionId",one.getSalesmanExtensionId());
            }
        }
       return mv;
    }

    /**
     * 业务人员注册信息
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView salesmanRegister(Salesman salesman){
        ModelAndView mv = new ModelAndView();
        log.info("业务人员注册信息开始执行,=========={}",salesman);
        Message message = salesmanService.addSalesman(salesman);
        mv.setViewName("salesmanRegister");
        mv.addObject("message",message);
        return mv;
    }


    /**
     * 回显所有业务员信息
     */
    @RequestMapping("/getAllSalesman")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView();
        log.info("获取所有业务人员信息开始执行");
        List<Salesman> salesmanList = salesmanService.getAll();
        if (salesmanList.size()>0) {
            for (Salesman salesman : salesmanList) {
                if (salesman.getStatus().equals("1")){
                    salesman.setStatus("审核中");
                }else if (salesman.getStatus().equals("2")){
                    salesman.setStatus("审核通过");
                }else if (salesman.getStatus().equals("3")){
                    salesman.setStatus("审核拒绝");
                }
                if (salesman.getType().equals("2")){
                    salesman.setType("业务员");
                }else if (salesman.getType().equals("1")){
                    salesman.setType("管理员");
                }
            }
        }
        mv.addObject("salesmanList",salesmanList);
        mv.setViewName("salesmanList");
        return mv;
    }

    /**
     * 根据推广码删除业务员
     */
    @RequestMapping("/salesman/delete")
    public void delete(String salesmanExtensionId){
        Message message = new Message();
        int i = salesmanService.deleteSalesmanByExtensionId(salesmanExtensionId);
        if (i > 0){
            message.setCode(MessageEnum.DELETE_SUCCESS.getCode());
            message.setMsg(MessageEnum.DELETE_SUCCESS.getMessage());
        }else {
            message.setCode(MessageEnum.DELETE_FAIL.getCode());
            message.setMsg(MessageEnum.DELETE_FAIL.getMessage());
        }
        System.out.println(salesmanExtensionId);

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
            boolean emp = isEmp(user);
            if (emp) {//参数全有
                //判断推广码是否还有效
                Salesman salesman = salesmanService.getOneBySalesmanExtensionId(user.getSalesmanId());
                if (salesman != null) {
                    message = userService.userRegister(user, message);
                }else {
                    message.setCode(MessageEnum.SALESMAN_NOT_EXIST.getCode());
                    message.setMsg(MessageEnum.SALESMAN_NOT_EXIST.getMessage());
                }
            }else {//参数有为空
                message.setCode(MessageEnum.PARAMETER_ERROR.getCode());
                message.setMsg(MessageEnum.PARAMETER_ERROR.getMessage());
            }
        }else {
            message.setCode(MessageEnum.PARAMETER_ERROR.getCode());
            message.setMsg(MessageEnum.PARAMETER_ERROR.getMessage());
        }
        return JSONObject.toJSON(message).toString();
    }


    /**
     * 客户注册入口
     * @param id 业务员推广码
     * @return 视图
     */
    @RequestMapping(value = "/context/{id}",method = RequestMethod.GET)
    public ModelAndView test(@PathVariable String id){
        log.info("根据推广码进行用户注册，============={}",id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userRegister");
        mv.addObject("id",id);
        return mv;
    }

    /**
     * 注册页面跳转登录页面
     * @return 页面
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }


    /**
     * 登录页面跳转注册页面
     * @return 页面
     */
    @RequestMapping(value = "/salesmanRegister",method = RequestMethod.GET)
    public String salesmanRegister(){
        return "salesmanRegister";
    }

    /**
     * 公共用户注册
     * @param publicUser 公共用户信息
     * @return 页面
     */
    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String publicUser(PublicUser publicUser){
        return "publicUserRegister";
    }

    /**
     * 公共用户注册
     * @return 视图
     */
    @RequestMapping(value = "/publicUserRegister",method = RequestMethod.POST)
    public ModelAndView publicUserRegister(PublicUser publicUser){
        System.out.println(publicUser);
        ModelAndView mv = new ModelAndView();
        Message message = new Message();
        boolean emp = isEmp(publicUser);
        if (emp){
            HashMap<String, String> map = new HashMap<>();
            map.put("name",publicUser.getName());
            map.put("phone",publicUser.getPhone());
            List<PublicUser> oneByNameAndPhone = publicUserService.getOneByNameAndPhone(map);
            if (oneByNameAndPhone.size() == 0){//没有注册过
                publicUser.setCreateTime(new Date());
                int save = publicUserService.save(publicUser);
                if (save > 0) {//注册成功
                    message.setCode(MessageEnum.REGISTER_SUCCESS.getCode());
                    message.setMsg(MessageEnum.REGISTER_SUCCESS.getMessage());
                    mv.setViewName("aa");
                }else {//注册失败
                    message.setCode(MessageEnum.REGISTER_FAIL.getCode());
                    message.setMsg(MessageEnum.REGISTER_FAIL.getMessage());
                    mv.setViewName("publicUserRegister");
                }
            }else {//用户名或者电话已被使用
                message.setCode(MessageEnum.REPEATED_REGISTRATION.getCode());
                message.setMsg(MessageEnum.REPEATED_REGISTRATION.getMessage());
                mv.setViewName("publicUserRegister");
            }
        }else {//注册参数有误
            message.setCode(MessageEnum.PARAMETER_ERROR.getCode());
            message.setMsg(MessageEnum.PARAMETER_ERROR.getMessage());
            mv.setViewName("publicUserRegister");
        }

        mv.addObject("msg",message);
        return mv;
    }


    boolean isEmp(PublicUser publicUser){
        if (publicUser.getName() != null && !publicUser.getName().equals("") && publicUser.getPhone() != null &&
                !publicUser.getPhone().equals("") && publicUser.getPassword() != null && !publicUser.getPassword().equals("")){
            return true;
        }else {
            return false;
        }
    }



    boolean isEmp(User user){
        if (user.getUserPhone() != null && !user.getUserPhone().equals("") && user.getUserName() != null &&
                !user.getUserName().equals("") && user.getSalesmanId() != null && !user.getSalesmanId().equals("")){
            return true;
        }else {
            return false;
        }
    }
}
