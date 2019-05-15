package com.cby.dao;

import com.cby.entity.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerMapper {
    int deleteByPrimaryKey(String workerId);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(String workerId);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);

    List<Worker> quickSelect(@Param("workerId") String workerId, @Param("workerName") String workerName, @Param("numbers") String numbers);

    int updatePassword(@Param("workerId") String workerId,@Param("password") String password);
}