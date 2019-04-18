package com.cby.entity;

import java.util.Date;

public class Repair {
    private String repairId;

    private String userId;

    private String workerId;

    private String repairInformation;

    private Date repairTime;

    private String repairCondition;

    private Date evaluationTime;

    private String evaluation;

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

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}