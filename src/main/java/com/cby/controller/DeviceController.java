package com.cby.controller;

import com.cby.entity.Device;
import com.cby.service.DeviceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    //快速查询
    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
        String devideId = param.get("devideId").toString();
        int intDevideId;
        if(devideId.equals("")) {
            devideId = null;
            intDevideId = 0;
        }
        else {
            intDevideId = Integer.parseInt(devideId);
        }
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
        List<Device> list = deviceService.quickSelect(intDevideId,page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        response.put("code",20000);
        res.put("pageData",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        response.put("data",res);
        return response;
    }

    //删除设备
    @RequestMapping(value = "/deleteDevice",method = RequestMethod.POST)
    public Map<String, Object> DeleteDevice(@RequestBody Map<String,Object> param){
        String devideId = param.get("devideId").toString();
        int intDevideId = Integer.parseInt(devideId);
        deviceService.deleteByPrimaryKey(intDevideId);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","删除成功");
        return response;
    }

    //新增设备
    @RequestMapping(value = "/addDevice",method = RequestMethod.POST)
    public Map<String, Object> AddDevice(@RequestBody Map<String,Object> param) throws ParseException {
        Device device = new Device();
        String devideName = param.get("devideName").toString();
        String startTime = param.get("startTime").toString();
        System.out.println(startTime);
        device.setDevideName(devideName);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Date time = sdf.parse(startTime);
        device.setStartTime(time);
        deviceService.insertSelective(device);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","提交成功");
        return response;
    }

    //检修设备
    @RequestMapping(value = "/checkDevice",method = RequestMethod.POST)
    public Map<String, Object> CheckDevice(@RequestBody Map<String,Object> param) throws ParseException {
        Device device = new Device();
        Device device2 = new Device();
        String devideId = param.get("devideId").toString();
        int intDevideId = Integer.parseInt(devideId);
        device2 = deviceService.selectByPrimaryKey(intDevideId);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = new Date();//获得系统时间.
        String nowTime = sdf.format(date);
        Date lastDate = sdf.parse( nowTime );
        device.setLastDate(lastDate);
        device.setDevideId(intDevideId);
        String nextDate = param.get("nextDate").toString();
        Date time = sdf.parse(nextDate);
        device.setNextDate(time);
        String ps = param.get("ps").toString();
        device.setPs(ps);
        System.out.println(device);
        deviceService.updateByPrimaryKeySelective(device);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","提交成功");
        return response;
    }
}
