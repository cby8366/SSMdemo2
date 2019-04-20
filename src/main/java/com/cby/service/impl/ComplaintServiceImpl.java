package com.cby.service.impl;

import com.cby.dao.ComplaintMapper;
import com.cby.entity.Complaint;
import com.cby.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper mapper;

    public int deleteByPrimaryKey(String complaintId){return mapper.deleteByPrimaryKey(complaintId);}

    public int insert(Complaint record){return mapper.insert(record);}

    public int insertSelective(Complaint record){return mapper.insertSelective(record);}

    public Complaint selectByPrimaryKey(String complaintId){return mapper.selectByPrimaryKey(complaintId);}

    public int updateByPrimaryKeySelective(Complaint record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(Complaint record){return mapper.updateByPrimaryKey(record);}
}
