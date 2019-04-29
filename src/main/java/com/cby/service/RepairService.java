package com.cby.service;

import com.cby.entity.Repair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairService {
    int deleteByPrimaryKey(String repairId);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(String repairId);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKeyWithBLOBs(Repair record);

    int updateByPrimaryKey(Repair record);

    List<Repair> quickSelect(@Param("repairId") String repairId, @Param("userId") String userId, @Param("workerId") String workerId, @Param("repairTime") String repairTime, @Param("page") String page, @Param("pageSize") String pageSize );
}
