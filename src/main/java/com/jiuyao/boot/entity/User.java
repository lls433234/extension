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
    private String userId;

    /**
     * 业务人员推广码
     */
    private String salesmanId;
    /**
     * 用户身份证
     */
    private String userIdCard;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 创建时间
     */
    private Date createTime;

}
