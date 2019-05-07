package com.cby.service.impl;

import com.cby.dao.PaymentMapper;
import com.cby.entity.Payment;
import com.cby.service.PaymentService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper mapper;

    public int deleteByPrimaryKey(Integer paymentId){return mapper.deleteByPrimaryKey(paymentId);}

    public int insert(Payment record){return mapper.insert(record);}

    public int insertSelective(Payment record){return mapper.insertSelective(record);}

    public Payment selectByPrimaryKey(Integer paymentId){return mapper.selectByPrimaryKey(paymentId);}

    public int updateByPrimaryKeySelective(Payment record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(Payment record){return mapper.updateByPrimaryKey(record);}

    public List<Payment> quickSelect(@Param("paymentId") int paymentId, @Param("userId") String userId, @Param("workerId") String workerId, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("page") String page, @Param("pageSize") String pageSize){
        int num = Integer.parseInt(page);
        int size = Integer.parseInt(pageSize);
        PageHelper.startPage( num, size);
        return mapper.quickSelect(paymentId,userId,workerId,beginTime,endTime);
    }
}
