package com.cby.controller;

import com.cby.entity.Payment;
import com.cby.service.PaymentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    //新增缴费
    @RequestMapping(value = "/addPayment",method = RequestMethod.POST)
    public Map<String, Object> AddPayment(@RequestBody Map<String,Object> param) throws ParseException {
        Payment payment = new Payment();
        String userId = param.get("userId").toString();
        String workerId = param.get("workerId").toString();
        int money = Integer.parseInt(param.get("money").toString());
        String beginTime = param.get("beginTime").toString();
        String endTime = param.get("endTime").toString();
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date paymentTime = sdf.parse( nowTime );
        String state;
        Map<String ,Object> response = new HashMap<>();
        return response;
//        Repair repair = new Repair();
//        String userId = param.get("userId").toString();
//        String repairType = param.get("repairType").toString();
//        String content = param.get("content").toString();
//        String repairInformation = repairType+"-----"+content;
//        System.out.println(repairInformation);
//        UUID uuid=UUID.randomUUID();//生成唯一序列id
//        String repairId = uuid.toString();
//        System.out.println(repairId);
//        repair.setRepairId(repairId);
//        repair.setUserId(userId);
//        repair.setRepairInformation(repairInformation);
//        repair.setRepairCondition("未接受");
//        Date date = new Date();//获得系统时间.
//        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
//        String nowTime = sdf.format(date);
//        Date time = sdf.parse( nowTime );
//        repair.setRepairTime(time);
//        System.out.println(repairInformation);
//        repairService.insertSelective(repair);
//        Map<String,Object> response = new HashMap<>();
//        response.put("code",20000);
//        response.put("message","提交成功");
//        return response;
    }

    //快速查询
    @RequestMapping(value = "/quickSelect",method = RequestMethod.POST)
    public Map<String, Object> QuickSelect(@RequestBody Map<String,Object> param){
//        int paymentId = Integer.parseInt(param.get("paymentId").toString());
        String paymentId = param.get("paymentId").toString();
        String userId = param.get("userId").toString();
        String workerId = param.get("workerId").toString();
        String beginTime;
        String endTime;
        List<String> paymentTime = new ArrayList<>();
        if(param.get("paymentTime")==null||param.get("paymentTime").equals("")) {
            beginTime=null;
            endTime=null;
        }else{
            paymentTime=(List<String>) param.get("paymentTime");
            beginTime = paymentTime.get(0);
            endTime = paymentTime.get(1);
        }
        String page = param.get("page").toString();
        String pageSize = param.get("pageSize").toString();
        int intPaymentId;
        if(paymentId.equals("")) {
            paymentId = null;
            intPaymentId = 0;
        }
        else {
            intPaymentId = Integer.parseInt(paymentId);
        }
        if(userId.equals("")) userId = null;
        if(workerId.equals("")) workerId = null;

        List<Payment> list = paymentService.quickSelect(intPaymentId,userId,workerId,beginTime,endTime,page,pageSize);
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
    @RequestMapping(value = "/deletePayment",method = RequestMethod.POST)
    public Map<String, Object> DeletePayment(@RequestBody Map<String,Object> param){
        int paymentId = Integer.parseInt(param.get("paymentId").toString());
        paymentService.deleteByPrimaryKey(paymentId);
        Map<String,Object> response = new HashMap<>();
        response.put("code",20000);
        response.put("message","删除成功");
        return response;
    }

}
