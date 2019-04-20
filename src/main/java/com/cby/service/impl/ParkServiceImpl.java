package com.cby.service.impl;

import com.cby.dao.ParkMapper;
import com.cby.entity.Park;
import com.cby.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkMapper mapper;

    public int deleteByPrimaryKey(String parkId){return mapper.deleteByPrimaryKey(parkId);}

    public int insert(Park record){return mapper.insert(record);}

    public int insertSelective(Park record){return mapper.insertSelective(record);}

    public Park selectByPrimaryKey(String parkId){return mapper.selectByPrimaryKey(parkId);}

    public int updateByPrimaryKeySelective(Park record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(Park record){return mapper.updateByPrimaryKey(record);}
}
