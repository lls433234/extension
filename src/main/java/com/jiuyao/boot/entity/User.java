package com.jiuyao.boot.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户表
 */
@Data
public class User {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 业务人员推广码
     */
    private String salesmanId;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
//    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

}
