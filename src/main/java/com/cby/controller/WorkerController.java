package com.cby.controller;

import com.cby.entity.Worker;
import com.cby.service.WorkerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.POST)
    public  Map<String, Object> SelectByPrimaryKey(@RequestBody Map<String, Object> param) {
        String workerId = param.get("workerId").toString();
        Worker worker = new Worker();
        worker = workerService.selectByPrimaryKey(workerId);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 20000);
        response.put("data",worker);
        return  response;
    }

    //快速查询
    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
        String workerId = param.get("workerId").toString();
        String workerName = param.get("workerName").toString();
        String numbers = param.get("numbers").toString();
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
        if(workerId.equals("")) workerId = null;
        if(workerName.equals("")) workerName = null;
        if(numbers.equals("")) numbers = null;
        List<Worker> list = workerService.quickSelect(workerId,workerName,numbers,page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        response.put("code",20000);
        res.put("pageData",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        response.put("data",res);
        return response;
    }

    //添加员工
    @RequestMapping(value = "addWorker",method = RequestMethod.POST)
    public Map<String,Object> AddWorker(@RequestBody Map<String,Object> param){
        String workerId = param.get("workerId").toString();
        String workerName = param.get("workerName").toString();
        String job = param.get("job").toString();
        String numbers = param.get("numbers").toString();
        String password = MD5Utils.MD5(param.get("password").toString());

        if(workerId.equals("")) workerId = null;
        if(workerName.equals("")) workerName = null;
        if(job.equals("")) job = null;
        if(numbers.equals("")) numbers = null;
        if(param.get("password").toString().equals("")) password = null;
        Worker worker = new Worker();
        worker.setWorkerId(workerId);
        worker.setWorkerName(workerName);
        worker.setJob(job);
        worker.setNumbers(numbers);
        worker.setPassword(password);
        Map<String,Object> response = new HashMap<>();
        if(workerService.selectByPrimaryKey(workerId) != null){
            response.put("code",20001);
            response.put("message","该员工ID已存在!");
            return  response;
        }
        else {
            workerService.insertSelective(worker);
            response.put("code",20000);
            response.put("data",worker);
            response.put("message","新增成功");
            return response;
        }
    }

    //删除员工
    @RequestMapping(value = "/deleteWorker",method = RequestMethod.POST)
    public Map<String,Object> DeleteWorker(@RequestBody Map<String,Object> param){
        String workerId = param.get("workerId").toString();
        workerService.deleteByPrimaryKey(workerId);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","删除成功");
        return response;
    }

    //批量删除
    @RequestMapping(value = "/deleteSelect", method = RequestMethod.POST)
    public Map<String, Object> DeleteSelect(@RequestBody Map<String, Object> param) {
        List<String> workerId = new ArrayList<>();
        workerId = (List<String>)param.get("workerIds");
        for (int i=0;i<workerId.size();i++)
        {
            workerService.deleteByPrimaryKey(workerId.get(i));
        }
        Map<String, Object> response = new HashMap<>();
        response.put("code", 20000);
        response.put("message", "删除成功");
        return response;
    }

    //编辑员工
    @RequestMapping(value = "editWorker",method = RequestMethod.POST)
    public Map<String,Object> editWorker(@RequestBody Map<String,Object> param){
        String workerId = param.get("workerId").toString();
        String workerName = param.get("workerName").toString();
        String job = param.get("job").toString();
        String numbers = param.get("numbers").toString();

        if(workerId.equals("")) workerId = null;
        if(workerName.equals("")) workerName = null;
        if(job.equals("")) job = null;
        if(numbers.equals("")) numbers = null;
        Worker worker = new Worker();
        worker.setWorkerId(workerId);
        worker.setWorkerName(workerName);
        worker.setJob(job);
        worker.setNumbers(numbers);
        worker.setPassword(workerService.selectByPrimaryKey(workerId).getPassword());
        workerService.updateByPrimaryKeySelective(worker);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("data",worker);
        response.put("message","修改成功");
        return response;
    }

    //修改密码
    @RequestMapping(value = "/updataPassword", method = RequestMethod.POST)
    public Map<String, Object> UpdataPassword(@RequestBody Map<String, Object> param) {
        String workerId = param.get("workerId").toString();
        String oldPassword = MD5Utils.MD5(param.get("oldPassword").toString());
        String password = MD5Utils.MD5(param.get("newPassword").toString());

        if (workerId.equals("")) workerId = null;
        if (oldPassword.equals("")) oldPassword = null;
        if (password.equals("")) password = null;

        Map<String, Object> response = new HashMap<>();
        if(oldPassword.equals(workerService.selectByPrimaryKey(workerId).getPassword())){
            workerService.updatePassword(workerId, password);
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
