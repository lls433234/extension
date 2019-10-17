package com.jiuyao.boot.entity.dto;

import lombok.Data;

@Data
public class Page {

    /**
     * 企业查询的页面数
     */
    private Integer pageNum;

    /**
     * 企业查询的页面大小
     */
    private Integer pageSize;
}
