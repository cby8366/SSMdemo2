package com.cby.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Device {
    private Integer devideId;

    private String workerId;

    private String devideName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date lastDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date nextDate;

    private String ps;

    public Integer getDevideId() {
        return devideId;
    }

    public void setDevideId(Integer devideId) {
        this.devideId = devideId;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getDevideName() {
        return devideName;
    }

    public void setDevideName(String devideName) {
        this.devideName = devideName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return "Device{" +
                "devideId=" + devideId +
                ", workerId='" + workerId + '\'' +
                ", devideName='" + devideName + '\'' +
                ", startTime=" + startTime +
                ", lastDate=" + lastDate +
                ", nextDate=" + nextDate +
                ", ps='" + ps + '\'' +
                '}';
    }
}