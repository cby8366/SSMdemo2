package com.cby.service.impl;

import com.cby.dao.UserMapper;
import com.cby.entity.User;
import com.cby.service.UserService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> quickSelect(@Param("userId") String userId, @Param("userName") String userName, @Param("numbers") String numbers, @Param("page") String page, @Param("pageSize") String pageSize ){
        int num = Integer.parseInt(page);
        int size = Integer.parseInt(pageSize);
        PageHelper.startPage( num, size);
        return mapper.quickSelect( userId, userName, numbers);
    }

   /* public ArrayList<User> selectSelective(User record){
        return mapper.selectSelective(record);
    }*/

}
