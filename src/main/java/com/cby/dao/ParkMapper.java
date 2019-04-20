package com.cby.dao;

import com.cby.entity.Park;

public interface ParkMapper {
    int deleteByPrimaryKey(String parkId);

    int insert(Park record);

    int insertSelective(Park record);

    Park selectByPrimaryKey(String parkId);

    int updateByPrimaryKeySelective(Park record);

    int updateByPrimaryKey(Park record);
}