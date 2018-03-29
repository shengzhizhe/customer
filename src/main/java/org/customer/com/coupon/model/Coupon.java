package org.customer.com.coupon.model;

import java.io.Serializable;
//优惠券
public class Coupon implements Serializable {
    //主键
    private String uuid;
    //起始时间
    private String startTime;
    //结束时间
    private String endTime;
    //商家
    private String businessaccount;
    //类型(1:折扣，2:抵现)
    private String type;
    //面额\折扣
    private Double number;
    //所属批次
    private String batch;
    //所属活动(活动主键)
    private String activity;
    //内容说明
    private String content;
    //使用地址
    private String address;
    //使用条件
    private String condition;

    public Coupon() {
    }

    public Coupon(String uuid, String startTime, String endTime, String businessaccount, String type, Double number, String batch, String activity, String content, String address, String condition) {
        this.uuid = uuid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.businessaccount = businessaccount;
        this.type = type;
        this.number = number;
        this.batch = batch;
        this.activity = activity;
        this.content = content;
        this.address = address;
        this.condition = condition;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBusinessaccount() {
        return businessaccount;
    }

    public void setBusinessaccount(String businessaccount) {
        this.businessaccount = businessaccount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "uuid='" + uuid + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", businessaccount='" + businessaccount + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                ", batch='" + batch + '\'' +
                ", activity='" + activity + '\'' +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
