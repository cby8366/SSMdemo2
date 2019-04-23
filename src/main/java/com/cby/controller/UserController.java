package com.cby.controller;

import com.cby.entity.User;
import com.cby.service.UserService;
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

    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
        String userId = param.get("userId").toString();
        String userName = param.get("userName").toString();
        String numbers = param.get("numbers").toString();
        System.out.println("userId  "+userId);
        System.out.println("userName  "+userName);
        System.out.println("numbers  "+numbers);
        if(userId.equals("")) userId = null;
        if(userName.equals("")) userName = null;
        if(numbers.equals("")) numbers = null;
        List<User> user = userService.quickSelect(userId,userName,numbers);
        Map<String,Object> response = new HashMap<>();
        if(user != null){
            response.put("code",20000);
            response.put("data",user);
            return response;
        }
        else {
            response.put("code",20001);
            response.put("message","无此业主");
            return response;
        }
    }
    /*@RequestMapping(value = "/getBuilding",method = RequestMethod.GET)
    public Map<String,Object> Building(){
        Map<String,Object> response = new HashMap<>();
        if (userService.selectBuilding()!=null){
            response.put("code",20000);
            response.put("data",userService.selectBuilding());
            return response;
        }
        else{
            response.put("code",20001);
            response.put("message","无数据");
            return response;
        }
    }*/
    /*@RequestMapping(value = "/userInBuilding",method = RequestMethod.POST)
    public List<User> UserInBuilding(@RequestBody Map<String,Object> param){
        String building = param.get("building").toString();
        return userService.selectByBuilding(building);
    }*/
    /*@RequestMapping(value = "/allUser",method = RequestMethod.GET)
    public Map<String, Object> AllUser(){
        List<User> list = userService.selectAllUser();
        Map<String,Object> response = new HashMap<>();
        if (list != null){
            response.put("code",20000);
            response.put("data",list);
            return response;
        }
        else {
            response.put("code",20001);
            response.put("message","无数据");
            return response;
        }
    }*/
}