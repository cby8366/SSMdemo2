package com.cby.controller;

import com.cby.entity.User;
import com.cby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller("/user")
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    /*@RequestMapping(value="/tologin")
    public String tologin() {
        return "login";
    }*/

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request){
        /*Map<String,String> map=new HashMap<String,String>();
        map.put("user_id", request.getParameter("user_id"));
        map.put("password", request.getParameter("password"));
        User user = userService.login(map);*/
       String str1 = request.getParameter("user_id");
       String str2 = request.getParameter("password");
       User user = userService.selectByPrimaryKey(str1);
        if(user != null){
            if (user.getPassword() == str2){
            System.out.println("1111");
            return "success";}
            else
            {return "flase";}
        }

        else {
            System.out.println("2222");
            return "flase";
        }

        /*User user1 = new User();
        user1 = userService.selectByPrimaryKey(request.getParameter("user_id"));
        if(user1!=null){
            if(user1.getPassword() == request.getParameter("password")){
                return "success";
            }
            else return "flase";
        }
        else return "flase";*/
        /*Map<String,String> map=new HashMap<String,String>();
        map.put("userId", user.getUserId());
        map.put("password", user.getPassword());
        if(userService.login(map)!=null){
            request.getSession().setAttribute("user",user);
            return "success";
        }
        else return "flase";*/

    }


    /*@RequestMapping(value="/user/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String loginValidate(HttpSession session, Model model, @ModelAttribute User user) {
        List<User> list = new ArrayList<User>();
        User record  = new User();
        record.setUserId(user.getUserId());
        list = userService.selectSelective(record);
        if (list.size() == 0) {
            model.addAttribute("status", 1);
        } else {
            record.setPassword(Encryption.MD5(user.getPassword()));
            list = userService.selectSelective(record);
            if (list.size() == 0) {
                model.addAttribute("status", 2);
            }
            record = list.get(0);
            session.setAttribute("user", record);
            model.addAttribute("status", 0);
        }

        return "login";
    }*/
}