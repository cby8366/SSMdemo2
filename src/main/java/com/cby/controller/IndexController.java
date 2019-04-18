package com.cby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    @RequestMapping(value = "/test/go")
    public String test1() {
        return "logintest";
    }

    @RequestMapping("/test/first/data={userName}")
    public String goDetail(@PathVariable("userName")String data, Model model){
        model.addAttribute("data", data);
        return "logintest";
    }
}