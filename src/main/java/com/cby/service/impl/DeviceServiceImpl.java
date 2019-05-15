package com.cby.service.impl;

import com.cby.dao.DeviceMapper;
import com.cby.entity.Device;
import com.cby.service.DeviceService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper mapper;

    public int deleteByPrimaryKey(Integer devideId){return mapper.deleteByPrimaryKey(devideId);}

    public int insert(Device record){return mapper.insert(record);}

    public int insertSelective(Device record){return mapper.insertSelective(record);}

    public Device selectByPrimaryKey(Integer devideId){return mapper.selectByPrimaryKey(devideId);}

    public int updateByPrimaryKeySelective(Device record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKeyWithBLOBs(Device record){return mapper.updateByPrimaryKeyWithBLOBs(record);}

    public int updateByPrimaryKey(Device record){return mapper.updateByPrimaryKey(record);}

    public List<Device> quickSelect(@Param("devideId") int devideId, @Param("page") String page, @Param("pageSize") String pageSize ){
        int num = Integer.parseInt(page);
        int size = Integer.parseInt(pageSize);
        PageHelper.startPage( num, size);
        return mapper.quickSelect(devideId);
    }
}
