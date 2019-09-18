package com.jiuyao.boot.controller;

import cn.hutool.core.lang.ObjectId;
import com.jiuyao.boot.entity.PublicUser;
import com.jiuyao.boot.entity.Salesman;
import com.jiuyao.boot.entity.User;
import com.jiuyao.boot.entity.dto.Message;
import com.jiuyao.boot.entity.dto.MessageEnum;
import com.jiuyao.boot.service.PublicUserService;
import com.jiuyao.boot.service.SalesmanService;
import com.jiuyao.boot.service.UserService;
import com.jiuyao.boot.service.impl.UploadService;
import com.jiuyao.boot.utils.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    @Autowired
    private UploadService uploadService;
    /***
     * 登录
     * @param salesman
     * @return
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
    @RequestMapping("/getAllPublic")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView();
        log.info("获取所有业务人员信息开始执行");
        List<PublicUser> all = publicUserService.getAll();
        if (all.size()>0) {
            for (PublicUser publicUser : all) {
                if (publicUser.getStatus().equals("1")){
                    publicUser.setStatus("审核拒绝");
                }else if (publicUser.getStatus().equals("2")){
                    publicUser.setStatus("审核通过");
                }else if (publicUser.getStatus().equals("3")){
                    publicUser.setStatus("未审核");
                }
            }
        }
        mv.addObject("all",all);
        mv.setViewName("publicUserList");
        return mv;
    }

    /**
     * 按条件搜索业务员
     * @return
     */
    @RequestMapping("/getPublicByParam")
    public ModelAndView getSalesmanByParam(@RequestParam("name")String name, @RequestParam("salesmanExtensionId")String salesmanExtensionId,@RequestParam("phone") String phone){
        System.out.println(name);
        System.out.println(salesmanExtensionId);
        System.out.println(phone);
        ModelAndView mv = new ModelAndView();
        HashMap<String, String> map = new HashMap<>();
        map.put("name",name);
        map.put("salesmanExtensionId",salesmanExtensionId);
        map.put("phone",phone);
        List<PublicUser> all = publicUserService.getPublicUser(map);
        if (all.size()>0) {
            for (PublicUser publicUser : all) {
                if (publicUser.getStatus().equals("1")){
                    publicUser.setStatus("审核拒绝");
                }else if (publicUser.getStatus().equals("2")){
                    publicUser.setStatus("审核通过");
                }else if (publicUser.getStatus().equals("3")){
                    publicUser.setStatus("未审核");
                }
            }
        }
        mv.setViewName("publicUserList");
        mv.addObject("all",all);
        return mv;
    }

    /**
     * 按條件搜索用戶
     */
    @RequestMapping(value = "/getUserByParam",method = RequestMethod.POST)
    public ModelAndView getUserByParam(@RequestParam("salesmanId") String salesmanId,@RequestParam("userPhone")String userPhone,@RequestParam("userName")String userName){
        ModelAndView mv = new ModelAndView();
        HashMap<String, String> map = new HashMap<>();
        map.put("salesmanId",salesmanId);
        map.put("userPhone",userPhone);
        map.put("userName",userName);
        List<User> allUserList = userService.getUser(map);
        if (allUserList.size()>0){
            for (User user : allUserList) {
                String salesmanId1 = user.getSalesmanId();
                PublicUser oneBySalesmanExtensionId = publicUserService.getOneBySalesmanExtensionId(salesmanId1);
                user.setSalesmanName(oneBySalesmanExtensionId.getName());
            }
        }
        mv.setViewName("userList");
        mv.addObject("allUserList",allUserList);
        return mv;
    }

    /**
     * 根据推广码删除业务员
     */
    @RequestMapping("/delete")
    public ModelAndView delete(String salesmanExtensionId){
        Message message = new Message();
        int i = publicUserService.deletePublicUserByExtensionId(salesmanExtensionId);
        if (i > 0){
            message.setCode(MessageEnum.DELETE_SUCCESS.getCode());
            message.setMsg(MessageEnum.DELETE_SUCCESS.getMessage());
        }else {
            message.setCode(MessageEnum.DELETE_FAIL.getCode());
            message.setMsg(MessageEnum.DELETE_FAIL.getMessage());
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("publicUserList");
        mv.addObject("message",message);
        return new ModelAndView("redirect:/getAllPublic");
//        return mv;
    }


    /**
     * 根据用户电话删除业务员的用户
     * @param userPhone 用户电话
     * @return
     */
    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(String userPhone){
        System.out.println(userPhone);
        int delete = userService.delete(userPhone);
        log.info("根据推广码删除用户结果，{}",delete);
        return new ModelAndView("redirect:/getUserByPublicUser");
    }



    /**
     * 用户根据二维码进行注册
     */
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public ModelAndView userRegister(User user){
        log.info("客户申请数据，{}",user);
        ModelAndView mv = new ModelAndView();
        Message message = new Message();
        //用户注册
        if (user != null ) {
            boolean emp = isEmp(user);
            if (emp) {//参数全有
                //先判断用户是否已经绑定过业务员
                HashMap<String, String> map = new HashMap<>();
                map.put("userName",user.getUserName());
                map.put("userPhone",user.getUserPhone());
                User one = userService.getOne(map);
                if (one == null){//客户没有被绑定
                    //判断推广码是否还有效
                    PublicUser oneBySalesmanExtensionId = publicUserService.getOneBySalesmanExtensionId(user.getSalesmanId());
                    if (oneBySalesmanExtensionId != null) {
                        message = userService.userRegister(user, message);
                    }else {
                        message.setCode(MessageEnum.SALESMAN_NOT_EXIST.getCode());
                        message.setMsg(MessageEnum.SALESMAN_NOT_EXIST.getMessage());
                    }
                }else {//客户被绑定过了
                    log.info("客户被绑定过");
                    message.setCode(MessageEnum.USERS_ARE_BOUND.getCode());
                    message.setMsg(MessageEnum.USERS_ARE_BOUND.getMessage());
                }
            }else {//参数有为空
                message.setCode(MessageEnum.PARAMETER_ERROR.getCode());
                message.setMsg(MessageEnum.PARAMETER_ERROR.getMessage());
            }
        }else {
            message.setCode(MessageEnum.PARAMETER_ERROR.getCode());
            message.setMsg(MessageEnum.PARAMETER_ERROR.getMessage());
        }

        mv.setViewName("userRegisterSuccess");
        mv.addObject("msg",message);
        return mv;
    }


    /**
     * 绑定客户注册的入口
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
                publicUser.setStatus("3");
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

    /**
     * 业务员审核页面跳转
     * @param
     * @return
     */
    @RequestMapping(value = "/getPublicUser")
    public ModelAndView publicUserRegister(){
        List<PublicUser> all = publicUserService.getAll();
        if (all.size()>0){
            for (PublicUser publicUser : all) {
                if (publicUser.getStatus() .equals("1")){
                    publicUser.setStatus("未通过");
                }else if (publicUser.getStatus() .equals("2")){
                    publicUser.setStatus("通过");
                }else if (publicUser.getStatus() .equals("3")){
                    publicUser.setStatus("未审核");
                }
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("publicSH");
        mv.addObject("allPublicUser",all);
        return mv;
    }

    /**
     * 审核用户申请
     * @return
     */
    @RequestMapping(value = "/examine")
    public ModelAndView examine(String phone,String status,String name){
        System.out.println(phone);
        System.out.println(status);
        System.out.println(name);
        ModelAndView mv = new ModelAndView();
        //更新用户审核状态
        HashMap<String, String> map = new HashMap<>();
        map.put("phone",phone);
        map.put("status",status);
        String salesmanExtensionId = ObjectId.next();//生成推广码
        map.put("salesmanExtensionId",salesmanExtensionId);
        int update = publicUserService.update(map);
        log.info("更新审核状态结果，{}",update);
        //生成链接
        String url = "http://192.168.0.104:8085/context/"+salesmanExtensionId;
        //配置生成路径
        String path = "src/main/resources/static/img";

        //生成文件名称
        String fileName = name+phone+".png";
        if (status.equals("2")){
            QrCodeUtil.createQrCode(url, path, fileName);
            String filePath = path+"\\"+fileName;
            File file = new File(filePath);
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            MultipartFile multipartFile = null;
            try {
                multipartFile = new MockMultipartFile("copy",fileName, ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            uploadService.uploadFile(multipartFile,"document");
        }
        return new ModelAndView("redirect:/getPublicUser");
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
