package com.cby.service.impl;

import com.cby.dao.UserMapper;
import com.cby.entity.User;
import com.cby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    public int deleteByPrimaryKey(String userId){return mapper.deleteByPrimaryKey(userId);}

    public int insert(User record) {
        return mapper.insert(record);
    }

    public int insertSelective(User record){return mapper.insertSelective(record);}

    public User selectByPrimaryKey(String userId){ return mapper.selectByPrimaryKey(userId);}

    public int updateByPrimaryKeySelective(User record){return mapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(User record){return mapper.updateByPrimaryKey(record);}

   /* public ArrayList<User> selectSelective(User record){
        return mapper.selectSelective(record);
    }*/

}
