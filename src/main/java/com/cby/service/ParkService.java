package com.cby.service;

import com.cby.entity.Park;

public interface ParkService {
    int deleteByPrimaryKey(String parkId);

    int insert(Park record);

    int insertSelective(Park record);

    Park selectByPrimaryKey(String parkId);

    int updateByPrimaryKeySelective(Park record);

    int updateByPrimaryKey(Park record);
}
