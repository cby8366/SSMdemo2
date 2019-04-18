package com.cby.dao;

import com.cby.entity.Worker;

public interface WorkerMapper {
    int deleteByPrimaryKey(String workerId);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(String workerId);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
}