package com.jiuyao.boot.entity;

import lombok.Data;

@Data
public class ServiceResult<Object> {

    private String data;

    private String msg;

    private Boolean succeed  ;
}
