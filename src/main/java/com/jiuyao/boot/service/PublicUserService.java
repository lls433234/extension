package com.jiuyao.boot.service;

import com.jiuyao.boot.entity.PublicUser;

import java.util.List;
import java.util.Map;

public interface PublicUserService {

    List<PublicUser> getOneByNameAndPhone(Map<String,String> map);

    int save(PublicUser publicUser);
}
