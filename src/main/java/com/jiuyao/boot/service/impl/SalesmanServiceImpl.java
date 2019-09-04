package com.jiuyao.boot.service.impl;

import cn.hutool.core.lang.ObjectId;
import com.alibaba.fastjson.JSONObject;
import com.jiuyao.boot.entity.Salesman;
import com.jiuyao.boot.entity.dto.Message;
import com.jiuyao.boot.entity.dto.MessageEnum;
import com.jiuyao.boot.mapper.SalesmanMapper;
import com.jiuyao.boot.service.SalesmanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
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

    @Override
    public int deleteSalesmanByExtensionId(String salesmanExtensionId) {
        int i = salesmanMapper.deleteByExtensionId();
        return i;
    }

    @Override
    public Salesman getOne(HashMap<String, String> map) {
        Salesman one = salesmanMapper.getOne(map);
        return one;
    }

    /**
     * 业务员注册
     * @param salesman 业务员实体对象
     * @return 增加结果
     */
    @Override
    public Message addSalesman(Salesman salesman) {
        Message message = new Message();
        ModelAndView mv = new ModelAndView();
        if (salesman != null) {
            String salesmanId = ObjectId.next();
            //设置推广码
            salesman.setSalesmanExtensionId(salesmanId);
            //设置创建时间
            salesman.setCreateTime(new Date());
            salesman.setStatus("2");
            salesman.setType("2");
            int register = salesmanService.register(salesman);
            if (register > 0){
                log.info("注册成功");
                message.setMsg(MessageEnum.REGISTER_SUCCESS.getMessage());
                message.setCode(MessageEnum.REGISTER_SUCCESS.getCode());
            }else {
                log.info("注册失败");
                message.setMsg(MessageEnum.REGISTER_FAIL.getMessage());
                message.setCode(MessageEnum.REGISTER_FAIL.getCode());
            }
        }else {
            message.setMsg(MessageEnum.PARAMETER_ERROR.getMessage());
            message.setCode(MessageEnum.PARAMETER_ERROR.getCode());
        }
        return message;
    }


}
