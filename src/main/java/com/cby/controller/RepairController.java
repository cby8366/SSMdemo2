package com.cby.controller;

import com.cby.entity.Repair;
import com.cby.service.RepairService;
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
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
        if(repairId.equals("")) repairId = null;
        if(userId.equals("")) userId = null;
        if(workerId.equals("")) workerId = null;
        List<Repair> list = repairService.quickSelect(repairId,userId,workerId,beginTime,endTime,page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        response.put("code",20000);
        res.put("pageData",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        response.put("data",res);
        return response;
    }

    @RequestMapping(value = "/accept",method = RequestMethod.POST)
    public Map<String, Object> Accept(@RequestBody Map<String,Object> param){
        String repairId = param.get("repairId").toString();
        String workerId = param.get("workerId").toString();
        String repairCondition = "已接受";
        System.out.println(repairId);
        System.out.println(workerId);
        repairService.accept(repairId,repairCondition,workerId);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        return response;
    }

    //删除报修记录
    @RequestMapping(value = "/deleteRepair",method = RequestMethod.POST)
    public Map<String, Object> DeleteRepair(@RequestBody Map<String,Object> param){
        String repairId = param.get("repairId").toString();
        repairService.deleteByPrimaryKey(repairId);
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
        UUID uuid=UUID.randomUUID();//生成唯一序列id
        String repairId = uuid.toString();
        System.out.println(repairId);
        repair.setRepairId(repairId);
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
}
