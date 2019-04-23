package com.cby.controller;

import com.cby.entity.Worker;
import com.cby.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
        String workerId = param.get("workerId").toString();
        String workerName = param.get("workerName").toString();
        String numbers = param.get("numbers").toString();
        System.out.println("workerId  "+workerId);
        System.out.println("workerName  "+workerName);
        System.out.println("numbers  "+numbers);
        if(workerId.equals("")) workerId = null;
        if(workerName.equals("")) workerName = null;
        if(numbers.equals("")) numbers = null;
        List<Worker> workerList = workerService.quickSelect(workerId,workerName,numbers);
        Map<String,Object> response = new HashMap<>();
        if(workerList != null){
            response.put("code",20000);
            response.put("data",workerList);
            return response;
        }
        else {
            response.put("code",20001);
            response.put("message","无此员工");
            return response;
        }
    }
}
