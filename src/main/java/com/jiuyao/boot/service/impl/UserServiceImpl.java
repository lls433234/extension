package com.jiuyao.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiuyao.boot.entity.User;
import com.jiuyao.boot.entity.YlLog;
import com.jiuyao.boot.entity.dto.Message;
import com.jiuyao.boot.mapper.UserMapper;
import com.jiuyao.boot.mapper.YlLogMapper;
import com.jiuyao.boot.service.UserService;
import com.jiuyao.boot.utils.method.ApiUtil;
import com.jiuyao.boot.utils.security.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

//    public static final String openApiUrl="https://test.masget.com:7385/openapi/rest";
//    public static final String appid = "400433579";
//    public static final String session = "5pvowrqo3c168oeltmsv8b1x3l0sr8om";
//    public static final String secretkey = "Wdf8MIAxXH3m1lyO";
//    public static final String method = "masget.base.register.app";

    public static final String openApiUrl="https://gw.masget.com:7385/openapi/rest";
    public static final String appid = "144977839639367680";
    public static final String session = "3b5f213ba45946a6be3ff42150987770";
    public static final String secretkey = "c9080cc3caa44396";
    public static final String method = "masget.base.register.app";

    @Resource
    private UserMapper userMapper;

    @Resource
    private YlLogMapper ylLogMapper;

    @Override
    @Transactional
    public Message userRegister(User user, Message message) {
        user.setCreateTime(new Date());
        //请求时间
        Date requestDate = new Date();
        int save = userMapper.save(user);
        if (save>0) {
            HashMap<Object, Object> map = new HashMap<>();
            map.put("staffname", user.getUserName());
            String s1 = MD5Util.string2MD5(user.getPassword());
            log.info(s1);
            map.put("loginpwd", s1);
            map.put("mobilephone", user.getUserPhone());
            map.put("salesmanId", user.getSalesmanId());
            String json1 = JSON.toJSONString(map);
            log.info("json1========,{}",json1);
            String s = ApiUtil.methodInvoke(openApiUrl, appid, session, secretkey, method, json1);
            log.info("s========,{}",s);
            YlLog ylLog = new YlLog();
            ylLog.setRequestContext(appid+"--"+session+"--"+secretkey+"--"+method+"--"+json1);
            ylLog.setResponseContext(s);
            ylLog.setRequestTime(requestDate);
            ylLog.setResponseTime(new Date());
            int save1 = ylLogMapper.save(ylLog);
            log.info("银联交互日志记录入库结果，============{}",save1);
            JSONObject jsObj = JSONObject.parseObject(s);
            if ("0".equals(jsObj.getString("ret"))) {
                log.info("注册成功");
                message.setMsg("注册成功");
                message.setCode("10000");
            }else {
                log.info("注册失败");
                message.setMsg("注册失败");
                message.setCode("10001");
                int delete = userMapper.delete(user.getUserPhone());
                log.info("删除结果，{}",delete);
            }
        }else {
            log.info("注册失败");
            message.setMsg("注册失败");
            message.setCode("10001");
        }
        log.info("返回结果================={}",message.toString());
        return message;
    }

    //获取所有核心企业
    @Override
    public String getAllHeXin() {
        log.info("-------------进入银联所有核心企业------------");
//        Page page = new Page();
//        page.setPageNum(1);
//        page.setPageSize(100);
//        String s1 = JSONObject.toJSON(page).toString();
        String s = ApiUtil.methodInvoke(openApiUrl, appid, session, secretkey, "masget.base.hcompany.get", "s1");
        log.info("查询核心企业的结果集{}",s);
        return s;
    }

    /**
     * 获取所有业务员绑定用户
     * @return
     */
    @Override
    public List<User> getAll() {
        List<User> all = userMapper.getAll();
        return all;
    }

    /**
     * 根据业务员推广码查询所有用户
     * @param salesmanExtensionId
     * @return
     */
    @Override
    public List<User> getAllBySalesmanExtensionId(String salesmanExtensionId) {
        List<User> allBySalesmanExtensionId = userMapper.getAllBySalesmanExtensionId(salesmanExtensionId);
        return allBySalesmanExtensionId;
    }

    @Override
    public User getOne(HashMap<String, String> map) {
        User one = userMapper.getOne(map);
        return one;
    }

    @Override
    public List<User> getUser(HashMap<String, String> map) {
        List<User> user = userMapper.getUser(map);
        return user;
    }

    @Override
    public int delete(String userPhone) {
        int delete = userMapper.delete(userPhone);
        return delete;
    }

    @Override
    public List<User> getAllByLimit(HashMap<Object, Object> map) {
        List<User> allByLimit = userMapper.getAllByLimit(map);
        return allByLimit;
    }


    public static void main(String[] args) {
//        String str = "123456";
//        String s = MD5Util.string2MD5(str);
//        System.out.println(s);
//        String s = ApiUtil.methodInvoke(openApiUrl, appid, session, secretkey, "masget.base.hcompany.get", "");
//        System.out.println(s);
    }
}
