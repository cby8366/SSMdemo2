package com.cby.controller;

import com.cby.entity.User;
import com.cby.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*@RequestMapping(value="/tologin")
    public String tologin() {
        return "login";
    }*/

    //快速查询
    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
        String userId = param.get("userId").toString();
        String userName = param.get("userName").toString();
        String numbers = param.get("numbers").toString();
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
        System.out.println("userId  "+userId);
        System.out.println("userName  "+userName);
        System.out.println("numbers  "+numbers);
        if(userId.equals("")) userId = null;
        if(userName.equals("")) userName = null;
        if(numbers.equals("")) numbers = null;
        List<User> list = userService.quickSelect(userId,userName,numbers,page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        response.put("code",20000);
        res.put("pageData",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        response.put("data",res);
        return response;
    }

//    //查询所有用户
//    @RequestMapping(value = "/allUser",method = RequestMethod.GET)
//    public Map<String, Object> AllUser(){
//        List<User> list = userService.selectAllUser();
//        PageInfo pageInfo = new PageInfo(list);
//        Map<String,Object> response = new HashMap<>();
//        response.put("code",20000);
//        Map<String,Object> res=new HashMap<>();
//        res.put("pageData",pageInfo.getList());
//        res.put("total",pageInfo.getTotal());
//        response.put("data",res);
//        return response;
//    }

    //添加用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Map<String,Object> addUser(@RequestBody Map<String,Object> param){
        String userId = param.get("userId").toString();
        String userName = param.get("userName").toString();
        String userSex = param.get("userSex").toString();
        String numbers = param.get("numbers").toString();
        String area = param.get("area").toString();
        String password = MD5Utils.MD5(param.get("password").toString());
        String building = param.get("building").toString();
        String room = param.get("room").toString();
        if(userId.equals("")) userId = null;
        if(userName.equals("")) userName = null;
        if(userSex.equals("")) userSex = null;
        if(numbers.equals("")) numbers = null;
        if(area.equals("")) area = null;
        if(param.get("password").toString().equals("")) password = null;
        if(building.equals("")) building = null;
        if(room.equals("")) room = null;
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserSex(userSex);
        user.setNumbers(numbers);
        user.setArea(area);
        user.setPassword(password);
        user.setBuilding(building);
        user.setRoom(room);
        System.out.println(user);
        Map<String,Object> response = new HashMap<>();
        if(userService.selectByPrimaryKey(userId) != null){
            response.put("code",20001);
            response.put("message","该业主ID已存在");
            return response;
        }else{
            userService.insertSelective(user);
            response.put("code",20000);
            response.put("data",user);
            response.put("message","新增成功");
            return response;
        }
    }

    //删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public Map<String,Object> DeleteUser(@RequestBody Map<String,Object> param){
        String userId = param.get("userId").toString();
        userService.deleteByPrimaryKey(userId);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","删除成功");
        return response;
    }

    //编辑用户
    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public Map<String,Object> EditUser(@RequestBody Map<String,Object> param){
        String userId = param.get("userId").toString();
        String userName = param.get("userName").toString();
        String userSex = param.get("userSex").toString();
        String numbers = param.get("numbers").toString();
        String area = param.get("area").toString();
        String building = param.get("building").toString();
        String room = param.get("room").toString();

        if(userId.equals("")) userId = null;
        if(userName.equals("")) userName = null;
        if(userSex.equals("")) userSex = null;
        if(numbers.equals("")) numbers = null;
        if(area.equals("")) area = null;
        if(building.equals("")) building = null;
        if(room.equals("")) room = null;
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserSex(userSex);
        user.setNumbers(numbers);
        user.setArea(area);
        user.setPassword(userService.selectByPrimaryKey(userId).getPassword());
        user.setBuilding(building);
        user.setRoom(room);
        System.out.println(user);
        userService.updateByPrimaryKeySelective(user);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("data",user);
        response.put("massage","修改成功");
        return response;
    }
}