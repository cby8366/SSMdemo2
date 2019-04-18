package com.cby.dao;

import com.cby.entity.Complaint;

public interface ComplaintMapper {
    int deleteByPrimaryKey(String complaintId);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(String complaintId);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
}