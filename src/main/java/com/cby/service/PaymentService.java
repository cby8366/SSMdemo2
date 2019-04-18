package com.cby.service;

import com.cby.entity.Payment;

public interface PaymentService {

    int deleteByPrimaryKey(String paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(String paymentId);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}
