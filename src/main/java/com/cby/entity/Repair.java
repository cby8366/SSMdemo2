package com.cby.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Repair {
    private String repairId;

    private String userId;

    private String workerId;

    private String repairInformation;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date repairTime;

    private String repairCondition;

    private String evaluation;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date evaluationTime;

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
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

    public String getRepairInformation() {
        return repairInformation;
    }

    public void setRepairInformation(String repairInformation) {
        this.repairInformation = repairInformation;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getRepairCondition() {
        return repairCondition;
    }

    public void setRepairCondition(String repairCondition) {
        this.repairCondition = repairCondition;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairId='" + repairId + '\'' +
                ", userId='" + userId + '\'' +
                ", workerId='" + workerId + '\'' +
                ", repairInformation='" + repairInformation + '\'' +
                ", repairTime=" + repairTime +
                ", repairCondition='" + repairCondition + '\'' +
                ", evaluation='" + evaluation + '\'' +
                ", evaluationTime=" + evaluationTime +
                '}';
    }
}