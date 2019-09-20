package com.jiuyao.boot.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 后台管理员
 */
@Data
@Component
public class Salesman {
    /**
     * 业务人员推广码
     */
    private Integer salesmanId;

    /**
     * 业务人员电话
     */
    private String salesmanName;

    /**
     * 业务人员的姓名
     */
    private String name;

    /**
     * 业务员密码
     */
    private String salesmanPassword;

    /**
     * 业务人员身份证号
     */
    private String salesmanIdCard;

    /**
     * 业务人员推广码
     */
    private String salesmanExtensionId;
    /**
     * 状态（1:审核中，2:审核通过，3:审核被拒）
     */
    private String status;
    /**
     * 类型（1:管理员，2:经销商）
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createTime;

}
