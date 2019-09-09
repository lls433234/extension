package com.jiuyao.boot.mapper;

import com.jiuyao.boot.entity.Salesman;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SalesmanMapper {

    int register(Salesman salesman);

    List<Salesman> getAll();

    /**
     * 分页查询
     * @return
     */
    List<Salesman> getAllByLimt();

    int deleteByExtensionId();

    Salesman getOne(HashMap<String, String> map);

    Salesman getOneBySalesmanExtensionId(String salesmanExtensionId);


}
