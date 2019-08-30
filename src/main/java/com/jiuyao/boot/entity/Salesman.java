package com.jiuyao.boot.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class Salesman {
    /**
     * 业务人员推广码
     */
    private String salesmanId;

    /**
     * 业务人员姓名
     */
    private String salesmanName;

    /**
     * 业务人员电话
     */
    private String salesmanPhone;

    /**
     * 业务人员身份证号
     */
    private String salesmanIdCard;

    /**
     * 业务人员推广码
     */
    private String salesmanExtensionId;

    /**
     * 创建时间
     */
    private Date createTime;
}
