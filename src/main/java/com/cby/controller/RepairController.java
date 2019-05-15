package com.cby.controller;

import com.cby.entity.Repair;
import com.cby.entity.User;
import com.cby.entity.Worker;
import com.cby.service.RepairService;
import com.cby.service.UserService;
import com.cby.service.WorkerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    //报修记录
    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
        String repairId = param.get("repairId").toString();
        String userId = param.get("userId").toString();
        String workerId = param.get("workerId").toString();
        String beginTime;
        String endTime;
        List<String> repairTime = new ArrayList<>();
        if(param.get("repairTime")==null||param.get("repairTime").equals("")) {
             beginTime=null;
             endTime=null;
        }else{
             repairTime=(List<String>) param.get("repairTime");
             beginTime = repairTime.get(0);
             endTime = repairTime.get(1);
        }
        int intRepairId;
        if(repairId.equals("")) {
            repairId = null;
            intRepairId = 0;
        }
        else {
            intRepairId = Integer.parseInt(repairId);
        }
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
//        User user = new User();
//        Worker worker = new Worker();
        if(userId.equals("")) userId = null;
//        else user = userService.selectByPrimaryKey(userId);
        if(workerId.equals("")) workerId = null;
//        else worker = workerService.selectByPrimaryKey(workerId);
        System.out.println(intRepairId);
        List<Repair> list = repairService.quickSelect(intRepairId,userId,workerId,beginTime,endTime,page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        response.put("code",20000);
        res.put("pageData",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        response.put("data",res);
        return response;
    }

    //接受报修
    @RequestMapping(value = "/accept",method = RequestMethod.POST)
    public Map<String, Object> Accept(@RequestBody Map<String,Object> param){
        String repairId = param.get("repairId").toString();
        String workerId = param.get("workerId").toString();
        String repairCondition = "已接受";
        System.out.println(repairId);
        System.out.println(workerId);
        int intRepairId = Integer.parseInt(repairId);
        repairService.accept(intRepairId,repairCondition,workerId);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        return response;
    }

    //完成报修
    @RequestMapping(value = "/over",method = RequestMethod.POST)
    public Map<String, Object> Over(@RequestBody Map<String,Object> param){
        String repairId = param.get("repairId").toString();
        String repairCondition = "已完成";
        System.out.println(repairId);
        int intRepairId = Integer.parseInt(repairId);
        repairService.over(intRepairId,repairCondition);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        return response;
    }

    //删除报修记录
    @RequestMapping(value = "/deleteRepair",method = RequestMethod.POST)
    public Map<String, Object> DeleteRepair(@RequestBody Map<String,Object> param){
        String repairId = param.get("repairId").toString();
        int intRepairId = Integer.parseInt(repairId);
        repairService.deleteByPrimaryKey(intRepairId);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","删除成功");
        return response;
    }

    //新增报修
    @RequestMapping(value = "/addRepair",method = RequestMethod.POST)
    public Map<String, Object> AddRepair(@RequestBody Map<String,Object> param) throws ParseException {
        Repair repair = new Repair();
        String userId = param.get("userId").toString();
        String repairType = param.get("repairType").toString();
        String content = param.get("content").toString();
        String repairInformation = repairType+"-----"+content;
        System.out.println(repairInformation);
        repair.setUserId(userId);
        repair.setRepairInformation(repairInformation);
        repair.setRepairCondition("未接受");
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = sdf.parse( nowTime );
        repair.setRepairTime(time);
        System.out.println(repairInformation);
        repairService.insertSelective(repair);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","提交成功");
        return response;
    }

    //评价
    @RequestMapping(value = "/evaluation",method = RequestMethod.POST)
    public Map<String, Object> Evaluation(@RequestBody Map<String,Object> param) throws ParseException {
        Repair repair = new Repair();
        String repairId = param.get("repairId").toString();
        String evaluation = param.get("evaluation").toString();
        int intRepairId = Integer.parseInt(repairId);
        repair = repairService.selectByPrimaryKey(intRepairId);
        repair.setEvaluation(evaluation);
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date evaluationTime = sdf.parse( nowTime );
        repair.setEvaluationTime(evaluationTime);
        repairService.updateByPrimaryKeySelective(repair);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","提交成功");
        return response;
    }
}
