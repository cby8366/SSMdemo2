package com.cby.service;

import com.cby.entity.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerService {

    int deleteByPrimaryKey(String workerId);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(String workerId);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);

    List<Worker> quickSelect(@Param("workerId") String workerId, @Param("workerName") String workerName, @Param("numbers") String numbers);

}
