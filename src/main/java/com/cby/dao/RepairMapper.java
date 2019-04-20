package com.cby.dao;

import com.cby.entity.Repair;

public interface RepairMapper {
    int deleteByPrimaryKey(String repairId);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(String repairId);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKeyWithBLOBs(Repair record);

    int updateByPrimaryKey(Repair record);
}