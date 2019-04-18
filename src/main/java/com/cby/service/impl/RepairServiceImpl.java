package com.cby.service.impl;

import com.cby.dao.RepairMapper;
import com.cby.entity.Repair;
import com.cby.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;

public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper mapper;

    public int deleteByPrimaryKey(String repairId){return mapper.deleteByPrimaryKey(repairId);}

    public int insert(Repair record){return mapper.insert(record);}

    public int insertSelective(Repair record){return mapper.insertSelective(record);}

    public Repair selectByPrimaryKey(String repairId){return mapper.selectByPrimaryKey(repairId);}

    public int updateByPrimaryKeySelective(Repair record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKeyWithBLOBs(Repair record){return mapper.updateByPrimaryKeyWithBLOBs(record);}

    public int updateByPrimaryKey(Repair record){return mapper.updateByPrimaryKey(record);}
}
