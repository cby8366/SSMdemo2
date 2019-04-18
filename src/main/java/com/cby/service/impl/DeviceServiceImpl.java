package com.cby.service.impl;

import com.cby.dao.DeviceMapper;
import com.cby.entity.Device;
import com.cby.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper mapper;

    public int deleteByPrimaryKey(String devideId){return mapper.deleteByPrimaryKey(devideId);}

    public int insert(Device record){return mapper.insert(record);}

    public int insertSelective(Device record){return mapper.insertSelective(record);}

    public Device selectByPrimaryKey(String devideId){return mapper.selectByPrimaryKey(devideId);}

    public int updateByPrimaryKeySelective(Device record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKeyWithBLOBs(Device record){return mapper.updateByPrimaryKeyWithBLOBs(record);}

    public int updateByPrimaryKey(Device record){return mapper.updateByPrimaryKey(record);}
}
