package com.cby.controller;

import com.cby.entity.User;
import com.cby.entity.Worker;
import com.cby.service.UserService;
import com.cby.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class LoginController {
    static Worker worker = new Worker();
    static User user = new User();
    @Autowired
    private WorkerService workerService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody Map<String,Object> param) {
        /*MD5Utils md5 = new MD5Utils();*/
        String userId =param.get("username").toString();
        String password =MD5Utils.MD5(param.get("password").toString());
        String type =param.get("type").toString();
        Boolean result = checkLogin(userId,password,type);
        if (result&&type.equals("1")) {
            System.out.println("success");
            Map<String,Object> response = new HashMap<>();
            response.put("code",20000);
            response.put("message","登录成功");
            response.put("data",user);
            return response;
        }else if (result&&type.equals("2")) {
            System.out.println("success");
            Map<String,Object> response = new HashMap<>();
            response.put("code",20000);
            response.put("message","登录成功");
            response.put("data",worker);
            return response;
        }else {
//            System.out.println("error");
            Map<String,Object> response = new HashMap<>();
            response.put("code",20001);
            response.put("message","用户名或密码错误");
            return response;
        }


    }
    public boolean checkLogin(String userId, String password, String type) {
        if (type.equals("1")) {
            user = userService.selectByPrimaryKey(userId);
            if (user == null || "".equals(user.getUserId())) {
                return false;
            }
            if (user.getPassword().trim().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else if (type.equals("2")){
            worker = workerService.selectByPrimaryKey(userId);
            if (worker == null || "".equals(worker.getWorkerId())) {
                return false;
            }
            if (worker.getPassword().trim() .equals(password)) {
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

    @RequestMapping(value = "/checkLogout",method = RequestMethod.POST )
    @ResponseBody
    public Map<String,Object> logout(){
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","注销成功");
        return response;
    }


}