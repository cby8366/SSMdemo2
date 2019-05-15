package com.cby.dao;


import com.cby.entity.Repair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairMapper {
    int deleteByPrimaryKey(Integer repairId);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(Integer repairId);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);

    List<Repair> quickSelect(@Param("repairId") int repairId, @Param("userId") String userId, @Param("workerId") String workerId, @Param("beginTime") String beginTime, @Param("endTime") String endTime);

    int accept(@Param("repairId") int repairId, @Param("repairCondition") String repairCondition,@Param("workerId") String workerId);

    int over(@Param("repairId") int repairId, @Param("repairCondition") String repairCondition);
}