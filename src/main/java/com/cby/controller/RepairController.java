package com.cby.controller;

import com.cby.entity.Repair;
import com.cby.entity.User;
import com.cby.service.RepairService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
        String repairId = param.get("repairId").toString();
        String userId = param.get("userId").toString();
        String workerId = param.get("workerId").toString();
        String repairTime = param.get("repairTime").toString();
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
        System.out.println("repairId:"+repairId);
        System.out.println("userId:"+userId);
        System.out.println("workerId:"+workerId);
        System.out.println("repairTime:"+repairTime);
        if(repairId.equals("")) repairId = null;
        if(userId.equals("")) userId = null;
        if(workerId.equals("")) workerId = null;
        if(repairTime.equals("")) repairTime = null;
        List<Repair> list = repairService.quickSelect(repairId,userId,workerId,repairTime,page,pageSize);
        for (Repair rep:list){
            System.out.println(rep);
        }
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        response.put("code",20000);
        res.put("pageData",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        response.put("data",res);
        return response;
    }
}
