package com.jiuyao.boot.mapper;

import com.jiuyao.boot.entity.Salesman;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesmanMapper {

    int register(Salesman salesman);
}
