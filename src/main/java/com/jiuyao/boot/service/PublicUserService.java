package com.jiuyao.boot.service;

import com.jiuyao.boot.entity.PublicUser;
import com.jiuyao.boot.entity.Salesman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PublicUserService {

    List<PublicUser> getOneByNameAndPhone(Map<String,String> map);

    int save(PublicUser publicUser);

    List<PublicUser> getAll();

    int update(HashMap<String, String> map);

    PublicUser getOneBySalesmanExtensionId(String salesmanId);

    List<PublicUser> getPublicUser(HashMap<String, String> map);

    int deletePublicUserByExtensionId(String salesmanExtensionId);
}
