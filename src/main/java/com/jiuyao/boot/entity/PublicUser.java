package com.jiuyao.boot.entity;

import lombok.Data;

import java.util.Date;

/**
 * 公共用户信息实体
 */
@Data
public class PublicUser {

    private Integer id;

    private String name;

    private String phone;

    private String password;

    private Date createTime;
}
