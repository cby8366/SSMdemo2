package com.cby.service;

import com.cby.entity.User;

public interface UserService {

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


//    ArrayList<User> selectSelective(User record);

}
