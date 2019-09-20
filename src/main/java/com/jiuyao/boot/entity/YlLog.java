package com.jiuyao.boot.entity;

import lombok.Data;

import java.util.Date;

/**
 * 银联日志实体
 */
@Data
public class YlLog {

    private Integer id;
    /**
     * 请求内容
     */
    private String requestContext;
    /**
     * 响应内容
     */
    private String responseContext;
    /**
     * 请求时间
     */
    private Date requestTime;
    /**
     * 响应时间
     */
    private Date responseTime;

}
