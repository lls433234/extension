package com.jiuyao.boot.service.impl;

import com.jiuyao.boot.entity.PublicUser;
import com.jiuyao.boot.mapper.PublicUserMapper;
import com.jiuyao.boot.service.PublicUserService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PublicUserServiceImpl implements PublicUserService {

    @Resource
    private PublicUserMapper publicUserMapper;

    @Override
    public List<PublicUser> getOneByNameAndPhone(Map<String,String> map) {
        List<PublicUser> oneByNameAndPhone = publicUserMapper.getOneByNameAndPhone(map);
        return oneByNameAndPhone;
    }

    /**
     * 添加公共用户
     * @param publicUser
     * @return
     */
    @Override
    public int save(PublicUser publicUser) {
        int save = publicUserMapper.save(publicUser);
        return save;
    }
}
