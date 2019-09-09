package com.jiuyao.boot.mapper;

import com.jiuyao.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int save(User user);

    List<User> getAll();

    List<User> getAllBySalesmanExtensionId(String salesmanExtensionId);
}
