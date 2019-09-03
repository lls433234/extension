package com.jiuyao.boot.service.impl;

import cn.hutool.core.lang.ObjectId;
import com.alibaba.fastjson.JSONObject;
import com.jiuyao.boot.entity.Salesman;
import com.jiuyao.boot.entity.dto.Message;
import com.jiuyao.boot.mapper.SalesmanMapper;
import com.jiuyao.boot.service.SalesmanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SalesmanServiceImpl implements SalesmanService {

    @Resource
    private SalesmanMapper salesmanMapper;

    @Autowired
    private SalesmanService salesmanService;

    @Override
    public int register(Salesman salesman) {
        return salesmanMapper.register(salesman);
    }

    @Override
    public List<Salesman> getAll() {
        List<Salesman> all = salesmanMapper.getAll();
        return all;
    }

    /**
     * 业务员注册
     * @param salesman
     * @return
     */
    @Override
    public String addSalesman(Salesman salesman) {
        Message message = new Message();
        ModelAndView mv = new ModelAndView();
        if (salesman != null) {
            String salesmanId = ObjectId.next();
            //设置推广码
            salesman.setSalesmanExtensionId(salesmanId);
            //设置创建时间
            salesman.setCreateTime(new Date());
            int register = salesmanService.register(salesman);
            if (register > 0){
                log.info("注册成功");
                message.setMsg("注册成功");
                message.setCode("10000");
            }else {
                log.info("注册失败");
                message.setMsg("注册失败");
                message.setCode("10001");
            }
        }else {
            message.setMsg("参数传递有误，请重新提交");
            message.setCode("10008");
        }
        return JSONObject.toJSON(message).toString();
    }


}
