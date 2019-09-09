package com.jiuyao.boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * 经销商绑定的用户表
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
     * 业务员名字
     */
    @Transient
    private String salesmanName;

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
