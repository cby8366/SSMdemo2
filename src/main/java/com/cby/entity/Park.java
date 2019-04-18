package com.cby.entity;

import java.util.Date;

public class Park {
    private String parkId;

    private String carportId;

    private String userId;

    private Date stsrtTime;

    private Date endTime;

    private String carId;

    private Integer price;

    private Integer money;

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getCarportId() {
        return carportId;
    }

    public void setCarportId(String carportId) {
        this.carportId = carportId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getStsrtTime() {
        return stsrtTime;
    }

    public void setStsrtTime(Date stsrtTime) {
        this.stsrtTime = stsrtTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}