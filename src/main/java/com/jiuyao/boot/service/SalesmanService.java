package com.jiuyao.boot.service;

import com.jiuyao.boot.entity.Salesman;
import com.jiuyao.boot.entity.dto.Message;

import java.util.HashMap;
import java.util.List;

public interface SalesmanService {

    int register(Salesman salesman);

    /**
     * 业务员注册（新增）
     * @param salesman
     * @return
     */
    Message addSalesman(Salesman salesman);

    List<Salesman> getAll();

    int deleteSalesmanByExtensionId(String salesmanExtensionId);

    Salesman getOne(HashMap<String, String> map);

    Salesman getOneBySalesmanExtensionId(String salesmanExtensionId);


    List<Salesman> getSalesman(HashMap<String, String> map);
}
