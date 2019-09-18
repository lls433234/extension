package com.jiuyao.boot.entity.dto;

import lombok.Data;

@Data
public class UserDto {

    /***
     *姓名
     */
    private String staffname;
    /**
     * 电话
     */
    private String mobilephone;
    /**
     * 登录密码（MD5加密）
     */
    private String loginpwd;
    /**
     * 推广码
     */
    private String salesmanId;
}
