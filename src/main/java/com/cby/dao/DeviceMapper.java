package com.cby.dao;

import com.cby.entity.Device;

public interface DeviceMapper {
    int deleteByPrimaryKey(String devideId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String devideId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKeyWithBLOBs(Device record);

    int updateByPrimaryKey(Device record);
}