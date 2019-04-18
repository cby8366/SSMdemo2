package com.cby.service.impl;

import com.cby.dao.WorkerMapper;
import com.cby.entity.Worker;
import com.cby.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerMapper mapper;

    public int deleteByPrimaryKey(String workerId){return mapper.deleteByPrimaryKey(workerId);}

    public int insert(Worker record){return mapper.insert(record);}

    public int insertSelective(Worker record){return mapper.insertSelective(record);}

    public Worker selectByPrimaryKey(String workerId){return mapper.selectByPrimaryKey(workerId);}

    public int updateByPrimaryKeySelective(Worker record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(Worker record){return mapper.updateByPrimaryKey(record);}
}
