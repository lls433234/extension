package com.jiuyao.boot.service;

import com.jiuyao.boot.entity.Salesman;

public interface SalesmanService {

    int register(Salesman salesman);

    /**
     * 业务员注册（新增）
     * @param salesman
     * @return
     */
    String addSalesman(Salesman salesman);
}
