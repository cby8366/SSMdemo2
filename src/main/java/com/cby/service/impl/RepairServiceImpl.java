package com.cby.service.impl;

import com.cby.dao.RepairMapper;
import com.cby.entity.Repair;
import com.cby.service.RepairService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper mapper;

    public int deleteByPrimaryKey(String repairId){return mapper.deleteByPrimaryKey(repairId);}

    public int insert(Repair record){return mapper.insert(record);}

    public int insertSelective(Repair record){return mapper.insertSelective(record);}

    public Repair selectByPrimaryKey(String repairId){return mapper.selectByPrimaryKey(repairId);}

    public int updateByPrimaryKeySelective(Repair record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(Repair record){return mapper.updateByPrimaryKey(record);}

    public List<Repair> quickSelect(@Param("repairId") String repairId, @Param("userId") String userId, @Param("workerId") String workerId, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("page") String page, @Param("pageSize") String pageSize ){
        int num = Integer.parseInt(page);
        int size = Integer.parseInt(pageSize);
        PageHelper.startPage( num, size);
        return mapper.quickSelect( repairId, userId, workerId, beginTime,endTime);
    }

    public int accept(@Param("repairId") String repairId, @Param("repairCondition") String repairCondition,@Param("workerId") String workerId){return mapper.accept(repairId,repairCondition,workerId);}

}
