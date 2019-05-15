package com.cby.service.impl;

import com.cby.dao.WorkerMapper;
import com.cby.entity.Worker;
import com.cby.service.WorkerService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerMapper mapper;

    public int deleteByPrimaryKey(String workerId){return mapper.deleteByPrimaryKey(workerId);}

    public int insert(Worker record){return mapper.insert(record);}

    public int insertSelective(Worker record){return mapper.insertSelective(record);}

    public Worker selectByPrimaryKey(String workerId){return mapper.selectByPrimaryKey(workerId);}

    public int updateByPrimaryKeySelective(Worker record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(Worker record){return mapper.updateByPrimaryKey(record);}

    public List<Worker> quickSelect(@Param("workerId") String workerId, @Param("workerName") String workerName, @Param("numbers") String numbers, @Param("page") String page, @Param("pageSize") String pageSize){
        int num = Integer.parseInt(page);
        int size = Integer.parseInt(pageSize);
        PageHelper.startPage( num, size);
        return mapper.quickSelect(workerId,workerName,numbers);
    }

    public int updatePassword(@Param("workerId") String workerId,@Param("password") String password){return mapper.updatePassword(workerId,password);}
}
