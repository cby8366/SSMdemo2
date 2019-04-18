package com.cby.service.impl;

import com.cby.dao.CarportMapper;
import com.cby.entity.Carport;
import org.springframework.beans.factory.annotation.Autowired;

public class CarportServiceImpl {

    @Autowired
    private CarportMapper mapper;

    public int deleteByPrimaryKey(String carportId){return mapper.deleteByPrimaryKey(carportId);}

    public int insert(Carport record){return  mapper.insert(record);}

    public int insertSelective(Carport record){return mapper.insertSelective(record);}
}
