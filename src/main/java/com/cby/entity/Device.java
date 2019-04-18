package com.cby.entity;

import java.util.Date;

public class Device {
    private String devideId;

    private String workerId;

    private String devideName;

    private Date startTime;

    private Date lastDate;

    private Date nextDate;

    private String ps;

    public String getDevideId() {
        return devideId;
    }

    public void setDevideId(String devideId) {
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
}