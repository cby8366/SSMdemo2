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


    //主键查询
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.POST)
    public  Map<String, Object> SelectByPrimaryKey(@RequestBody Map<String, Object> param) {
        String userId = param.get("userId").toString();
        User user = new User();
        user = userService.selectByPrimaryKey(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 20000);
        response.put("data",user);
        return  response;
    }

    //快速查询
    @RequestMapping(value = "/quickSelect", method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String, Object> param) {
        String userId = param.get("userId").toString();
        String userName = param.get("userName").toString();
        String numbers = param.get("numbers").toString();
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
        if (userId.equals("")) userId = null;
        if (userName.equals("")) userName = null;
        if (numbers.equals("")) numbers = null;
        List<User> list = userService.quickSelect(userId, userName, numbers, page, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        response.put("code", 20000);
        res.put("pageData", pageInfo.getList());
        res.put("total", pageInfo.getTotal());
        response.put("data", res);
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
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Map<String, Object> addUser(@RequestBody Map<String, Object> param) {
        String userId = param.get("userId").toString();
        String userName = param.get("userName").toString();
        String userSex = param.get("userSex").toString();
        String numbers = param.get("numbers").toString();
        String area = param.get("area").toString();
        String password = MD5Utils.MD5(param.get("password").toString());
        String building = param.get("building").toString();
        String room = param.get("room").toString();
        if (userId.equals("")) userId = null;
        if (userName.equals("")) userName = null;
        if (userSex.equals("")) userSex = null;
        if (numbers.equals("")) numbers = null;
        if (area.equals("")) area = null;
        if (param.get("password").toString().equals("")) password = null;
        if (building.equals("")) building = null;
        if (room.equals("")) room = null;
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserSex(userSex);
        user.setNumbers(numbers);
        user.setArea(area);
        user.setPassword(password);
        user.setBuilding(building);
        user.setRoom(room);
        Map<String, Object> response = new HashMap<>();
        if (userService.selectByPrimaryKey(userId) != null) {
            response.put("code", 20001);
            response.put("message", "该业主ID已存在");
            return response;
        } else {
            userService.insertSelective(user);
            response.put("code", 20000);
            response.put("data", user);
            response.put("message", "新增成功");
            return response;
        }
    }

    //删除用户
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public Map<String, Object> DeleteUser(@RequestBody Map<String, Object> param) {
        String userId = param.get("userId").toString();
        userService.deleteByPrimaryKey(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 20000);
        response.put("message", "删除成功");
        return response;
    }

    //批量删除
    @RequestMapping(value = "/deleteSelect", method = RequestMethod.POST)
    public Map<String, Object> DeleteSelect(@RequestBody Map<String, Object> param) {
        List<String> userId = new ArrayList<>();
        userId = (List<String>)param.get("userIds");
        for (int i=0;i<userId.size();i++)
        {
            userService.deleteByPrimaryKey(userId.get(i));
        }
        Map<String, Object> response = new HashMap<>();
        response.put("code", 20000);
        response.put("message", "删除成功");
        return response;
    }

    //编辑用户
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public Map<String, Object> EditUser(@RequestBody Map<String, Object> param) {
        String userId = param.get("userId").toString();
        String userName = param.get("userName").toString();
        String userSex = param.get("userSex").toString();
        String numbers = param.get("numbers").toString();
        String area = param.get("area").toString();
        String building = param.get("building").toString();
        String room = param.get("room").toString();

        if (userId.equals("")) userId = null;
        if (userName.equals("")) userName = null;
        if (userSex.equals("")) userSex = null;
        if (numbers.equals("")) numbers = null;
        if (area.equals("")) area = null;
        if (building.equals("")) building = null;
        if (room.equals("")) room = null;
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserSex(userSex);
        user.setNumbers(numbers);
        user.setArea(area);
        user.setPassword(userService.selectByPrimaryKey(userId).getPassword());
        user.setBuilding(building);
        user.setRoom(room);
        userService.updateByPrimaryKeySelective(user);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 20000);
        response.put("data", user);
        response.put("message", "修改成功");
        return response;
    }

    //修改密码
    @RequestMapping(value = "/updataPassword", method = RequestMethod.POST)
    public Map<String, Object> UpdataPassword(@RequestBody Map<String, Object> param) {
        String userId = param.get("userId").toString();
        String oldPassword = MD5Utils.MD5(param.get("oldPassword").toString());
        String password = MD5Utils.MD5(param.get("newPassword").toString());

        if (userId.equals("")) userId = null;
        if (oldPassword.equals("")) oldPassword = null;
        if (password.equals("")) password = null;

        Map<String, Object> response = new HashMap<>();
        if(oldPassword.equals(userService.selectByPrimaryKey(userId).getPassword())){
            userService.updatePassword(userId, password);
            response.put("code", 20000);
            response.put("message", "修改成功");
            return response;
        }else{
            System.out.println("原密码错误");
            response.put("code", 20001);
            response.put("message", "修改失败，原密码错误");
            return response;
        }
    }
}