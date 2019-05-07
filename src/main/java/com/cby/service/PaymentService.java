package com.cby.service;

import com.cby.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {

    int deleteByPrimaryKey(Integer paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Integer paymentId);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);

    List<Payment> quickSelect(@Param("paymentId") int paymentId, @Param("userId") String userId, @Param("workerId") String workerId, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("page") String page, @Param("pageSize") String pageSize);
}
