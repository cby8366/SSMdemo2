package com.cby.dao;

import com.cby.entity.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(Integer devideId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Integer devideId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKeyWithBLOBs(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> quickSelect(@Param("devideId") int devideId);
}