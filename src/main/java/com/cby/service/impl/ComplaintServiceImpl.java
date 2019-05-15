package com.cby.service.impl;

import com.cby.dao.ComplaintMapper;
import com.cby.entity.Complaint;
import com.cby.service.ComplaintService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper mapper;

    public int deleteByPrimaryKey(Integer complaintId){return mapper.deleteByPrimaryKey(complaintId);}

    public int insert(Complaint record){return mapper.insert(record);}

    public int insertSelective(Complaint record){return mapper.insertSelective(record);}

    public Complaint selectByPrimaryKey(Integer complaintId){return mapper.selectByPrimaryKey(complaintId);}

    public int updateByPrimaryKeySelective(Complaint record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(Complaint record){return mapper.updateByPrimaryKey(record);}

    public List<Complaint> quickSelect(@Param("complaintId") int complaintId, @Param("userId") String userId, @Param("workerId") String workerId, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("page") String page, @Param("pageSize") String pageSize ){
        int num = Integer.parseInt(page);
        int size = Integer.parseInt(pageSize);
        PageHelper.startPage( num, size);
        return mapper.quickSelect( complaintId, userId, workerId, beginTime,endTime);
    }

}
