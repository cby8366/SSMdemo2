package com.cby.dao;

import com.cby.entity.Complaint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplaintMapper {
    int deleteByPrimaryKey(Integer complaintId);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(Integer complaintId);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);

    List<Complaint> quickSelect(@Param("complaintId") int complaintId, @Param("userId") String userId, @Param("workerId") String workerId, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
}