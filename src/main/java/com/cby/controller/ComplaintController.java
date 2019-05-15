package com.cby.controller;

import com.cby.entity.Complaint;
import com.cby.service.ComplaintService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    //快速查询
    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
        String complaintId = param.get("complaintId").toString();
        String userId = param.get("userId").toString();
        String workerId = param.get("workerId").toString();
        String beginTime;
        String endTime;
        List<String> complaintTime = new ArrayList<>();
        if(param.get("complaintTime")==null||param.get("complaintTime").equals("")) {
            beginTime=null;
            endTime=null;
        }else{
            complaintTime=(List<String>) param.get("complaintTime");
            beginTime = complaintTime.get(0);
            endTime = complaintTime.get(1);
        }
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
        int intComplaintId;
        if(complaintId.equals("")) {
            complaintId = null;
            intComplaintId = 0;
        }
        else {
            intComplaintId = Integer.parseInt(complaintId);
        }
        if(userId.equals("")) userId = null;
        if(workerId.equals("")) workerId = null;

        List<Complaint> list = complaintService.quickSelect(intComplaintId,userId,workerId,beginTime,endTime,page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        response.put("code",20000);
        res.put("pageData",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        response.put("data",res);
        return response;
    }

    //删除记录
    @RequestMapping(value = "/deleteComplaint",method = RequestMethod.POST)
    public Map<String, Object> DeleteComplaint(@RequestBody Map<String,Object> param){
        int complaintId = Integer.parseInt(param.get("complaintId").toString());
        complaintService.deleteByPrimaryKey(complaintId);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","删除成功");
        return response;
    }

    //回复
    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    public Map<String, Object> Reply(@RequestBody Map<String,Object> param) throws ParseException, ParseException {
        Complaint complaint = new Complaint();
        int complaintId = Integer.parseInt(param.get("complaintId").toString());
        String workerId = param.get("workerId").toString();
        String reply = param.get("reply").toString();
        complaint = complaintService.selectByPrimaryKey(complaintId);
        complaint.setReply(reply);
        complaint.setWorkerId(workerId);
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date replyTime = sdf.parse( nowTime );
        complaint.setReplyTime(replyTime);
        complaintService.updateByPrimaryKeySelective(complaint);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","回复成功");
        return response;
    }

    //新增投诉
    @RequestMapping(value = "/addComplaint",method = RequestMethod.POST)
    public Map<String, Object> AddComplaint(@RequestBody Map<String,Object> param) throws ParseException {
        Complaint complaint = new Complaint();
        String userId = param.get("userId").toString();
        String content = param.get("content").toString();
        complaint.setUserId(userId);
        complaint.setContent(content);
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = sdf.parse( nowTime );
        complaint.setComplaintTime(time);
        complaintService.insertSelective(complaint);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","提交成功");
        return response;
    }
}
