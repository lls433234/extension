package com.jiuyao.boot.mapper;

import com.jiuyao.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {

    int save(User user);

    List<User> getAll();

    List<User> getAllBySalesmanExtensionId(String salesmanExtensionId);

    User getOne(HashMap<String, String> map);


    List<User> getUser(HashMap<String, String> map);

    int delete(String userPhone);
}
