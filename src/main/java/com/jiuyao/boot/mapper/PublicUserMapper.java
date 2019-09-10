package com.jiuyao.boot.mapper;

import com.jiuyao.boot.entity.PublicUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface PublicUserMapper {

    List<PublicUser> getOneByNameAndPhone(Map map);

    int save(PublicUser publicUser);

    List<PublicUser> getAll();

    int update(HashMap<String, String> map);
}
