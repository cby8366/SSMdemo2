package com.cby.service.impl;

import com.cby.dao.PaymentMapper;
import com.cby.entity.Payment;
import com.cby.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper mapper;

    public int deleteByPrimaryKey(String paymentId){return mapper.deleteByPrimaryKey(paymentId);}

    public int insert(Payment record){return mapper.insert(record);}

    public int insertSelective(Payment record){return mapper.insertSelective(record);}

    public Payment selectByPrimaryKey(String paymentId){return mapper.selectByPrimaryKey(paymentId);}

    public int updateByPrimaryKeySelective(Payment record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(Payment record){return mapper.updateByPrimaryKey(record);}
}
