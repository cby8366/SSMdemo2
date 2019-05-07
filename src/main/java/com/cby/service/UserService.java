package com.cby.service;

import com.cby.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> quickSelect(@Param("userId") String userId, @Param("userName") String userName, @Param("numbers") String numbers, @Param("page") String page, @Param("pageSize") String pageSize);

    int updatePassword(@Param("userId") String userId,@Param("password") String password);
//    ArrayList<User> selectSelective(User record);
}
