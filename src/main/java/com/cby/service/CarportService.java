package com.cby.service;

import com.cby.entity.Carport;

public interface CarportService {

    int deleteByPrimaryKey(String carportId);

    int insert(Carport record);

    int insertSelective(Carport record);
}
