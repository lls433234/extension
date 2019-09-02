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
}
