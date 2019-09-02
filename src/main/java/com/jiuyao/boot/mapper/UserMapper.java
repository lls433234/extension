package com.jiuyao.boot.mapper;

import com.jiuyao.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int save(User user);
}
