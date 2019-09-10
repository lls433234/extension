package com.jiuyao.boot.service;


import com.jiuyao.boot.entity.User;
import com.jiuyao.boot.entity.dto.Message;

import java.util.HashMap;
import java.util.List;

public interface UserService {


    Message userRegister(User user, Message message);

    List<User> getAll();

    List<User> getAllBySalesmanExtensionId(String salesmanExtensionId);

    User getOne(HashMap<String, String> map);


    List<User> getUser(HashMap<String, String> map);

    int delete(String userPhone);
}
