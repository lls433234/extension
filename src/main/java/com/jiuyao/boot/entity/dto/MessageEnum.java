package com.jiuyao.boot.entity.dto;

import lombok.Getter;
/**
 *
 */
@Getter
public enum MessageEnum {
    REGISTER_SUCCESS("10000", "注册成功"),
    REGISTER_FAIL("10001", "注册失败"),
    PARAMETER_ERROR("10008", "注册信息不完整，请重新提交"),
    DELETE_SUCCESS("10010", "删除成功"),
    DELETE_FAIL("10020", "删除失败"),
    REPEATED_REGISTRATION("10030","用户名或者电话已被使用"),
    ;

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    MessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
