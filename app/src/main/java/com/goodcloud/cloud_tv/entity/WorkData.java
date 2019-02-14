package com.goodcloud.cloud_tv.entity;


import java.util.List;

public class WorkData {

    private List rows;
    private String machineName;//线体
    private String workShiftName;//班次
    private String userName;//产线负责人
    private String code;//产品编号
    private String productName;//产品名称
    private Integer planNum;//计划数
    private Integer reallyNum;//下线数
    private String difference;//差额
    private String completionRate;//完成率
    private Integer status;//生产状态

    public WorkData() {
    }

    public WorkData(List rows, String machineName, String workShiftName, String userName, String code, String productName, Integer planNum, Integer reallyNum, String difference, String completionRate, Integer status) {
        this.rows = rows;
        this.machineName = machineName;
        this.workShiftName = workShiftName;
        this.userName = userName;
        this.code = code;
        this.productName = productName;
        this.planNum = planNum;
        this.reallyNum = reallyNum;
        this.difference = difference;
        this.completionRate = completionRate;
        this.status = status;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getWorkShiftName() {
        return workShiftName;
    }

    public void setWorkShiftName(String workShiftName) {
        this.workShiftName = workShiftName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPlanNum() {
        return planNum;
    }

    public void setPlanNum(Integer planNum) {
        this.planNum = planNum;
    }

    public Integer getReallyNum() {
        return reallyNum;
    }

    public void setReallyNum(Integer reallyNum) {
        this.reallyNum = reallyNum;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public String getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(String completionRate) {
        this.completionRate = completionRate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

