package com.goodcloud.cloud_tv.entity;

public class Andeng {

    private String areaName;//"区域名称
    private Long arriveTime;//到达时间
    private String arriveUserName;//"到达人员名称
    private Integer buttonAttrInfoId;//按钮信息id  (1:故障,2:缺料,3:调机)
    private String confirmCompleteUserName;//确认完成用户id
    private Long lastChangeTime;//数据最后一次改变时间
    private String triggerName;//触发终端名称
    private Integer value;//对应按钮值(1:故障,2:缺料,3:调机)

    public Andeng() {
    }

    public Andeng(String areaName, Long arriveTime, String arriveUserName, Integer buttonAttrInfoId, String confirmCompleteUserName, Long lastChangeTime, String triggerName, Integer value) {
        this.areaName = areaName;
        this.arriveTime = arriveTime;
        this.arriveUserName = arriveUserName;
        this.buttonAttrInfoId = buttonAttrInfoId;
        this.confirmCompleteUserName = confirmCompleteUserName;
        this.lastChangeTime = lastChangeTime;
        this.triggerName = triggerName;
        this.value = value;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Long arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveUserName() {
        return arriveUserName;
    }

    public void setArriveUserName(String arriveUserName) {
        this.arriveUserName = arriveUserName;
    }

    public Integer getButtonAttrInfoId() {
        return buttonAttrInfoId;
    }

    public void setButtonAttrInfoId(Integer buttonAttrInfoId) {
        this.buttonAttrInfoId = buttonAttrInfoId;
    }

    public String getConfirmCompleteUserName() {
        return confirmCompleteUserName;
    }

    public void setConfirmCompleteUserName(String confirmCompleteUserName) {
        this.confirmCompleteUserName = confirmCompleteUserName;
    }

    public Long getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(Long lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
