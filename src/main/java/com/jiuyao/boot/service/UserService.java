package com.jiuyao.boot.service;


import com.jiuyao.boot.entity.User;
import com.jiuyao.boot.entity.dto.Message;

public interface UserService {


    Message userRegister(User user, Message message);
}
