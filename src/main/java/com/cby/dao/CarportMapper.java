package com.cby.dao;

import com.cby.entity.Carport;

public interface CarportMapper {
    int deleteByPrimaryKey(String carportId);

    int insert(Carport record);

    int insertSelective(Carport record);
}