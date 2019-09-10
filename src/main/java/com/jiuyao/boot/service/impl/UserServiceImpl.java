package com.jiuyao.boot.service.impl;

import com.jiuyao.boot.entity.User;
import com.jiuyao.boot.entity.dto.Message;
import com.jiuyao.boot.mapper.UserMapper;
import com.jiuyao.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public Message userRegister(User user, Message message) {
        user.setCreateTime(new Date());
        int save = userMapper.save(user);
        if (save > 0){
            log.info("注册成功");
            message.setMsg("注册成功");
            message.setCode("10000");
        }else {
            log.info("注册失败");
            message.setMsg("注册失败");
            message.setCode("10001");
        }
        return message;
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


}
