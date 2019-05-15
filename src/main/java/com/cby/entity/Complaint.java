package com.cby.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Complaint {
    private Integer complaintId;

    private String userId;

    private String workerId;

    private String content;

    private String reply;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date complaintTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date replyTime;

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getComplaintTime() {
        return complaintTime;
    }

    public void setComplaintTime(Date complaintTime) {
        this.complaintTime = complaintTime;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}