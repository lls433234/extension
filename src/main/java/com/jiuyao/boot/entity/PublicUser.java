package com.jiuyao.boot.entity;

import lombok.Data;

import java.util.Date;

/**
 * 业务员
 */
@Data
public class PublicUser {

    private Integer id;

    private String name;

    private String phone;

    private String password;

    /**
     * 推广码
     */
    private String salesmanExtensionId;

    /**
     * 用户类型（1.经销商；2.普通用户）
     */
//    private String type;
    /**
     * 审核状态（1:未通过；2:通过；3:未审核）
     */
    private String status;

    private Date createTime;
}
