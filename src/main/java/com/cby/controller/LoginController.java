package com.cby.controller;

import com.cby.entity.User;
import com.cby.entity.Worker;
import com.cby.service.UserService;
import com.cby.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    private WorkerService workerService;

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request) {
        System.out.println("进入该方法");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        System.out.println("request.getParameter   " + userId);
        System.out.println("request.getParameter   " + password);
        System.out.println("request.getParameter   " + type);
        Boolean result = checkLogin(userId, password, type);
        if (result) {
            System.out.println("1");
            return "success";
        } else {
            System.out.println("0");
            return "false";
        }
    }
/*
        Boolean result = checkLogin(userId,password);
        Map<String, Object> map = new HashMap<>();

        if (result) {
            map.put("code", 0);
            map.put("tureInfo","登录成功");
        }
        else{
            map.put("code", 1);
            map.put("errorInfo","登录失败，请重新登录");
        }
        return map;*/


    public boolean checkLogin(String userId, String password, String type) {
        if (type.equals("1")) {
            User user = userService.selectByPrimaryKey(userId);
            if (user == null || "".equals(user)) {
                return false;
            }
            if (user.getPassword().equals(password)) {
                System.out.println(user.getUserId() + " " + user.getPassword());
                return true;
            } else {
                return false;
            }
        } else if (type.equals("2")){
            Worker worker = workerService.selectByPrimaryKey(userId);
            if (worker == null || "".equals(worker)) {
                return false;
            }
            if (worker.getPassword().equals(password)) {
                System.out.println(worker.getWorkerId() + " " + worker.getPassword());
                return true;
            } else {
                return false;
            }
        }
        else {
            System.out.println("类型错误");
            return false;
        }

    }
}