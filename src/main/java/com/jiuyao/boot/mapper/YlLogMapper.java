package com.jiuyao.boot.mapper;

import com.jiuyao.boot.entity.YlLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 银联交互日志mapper
 */
@Mapper
public interface YlLogMapper {

    int save(YlLog ylLog);

}
