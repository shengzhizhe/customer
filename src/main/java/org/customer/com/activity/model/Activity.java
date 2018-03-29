package org.customer.com.activity.model;

import java.io.Serializable;
import java.sql.Timestamp;

//活动
public class Activity implements Serializable {
    //主键
    private String uuid;
    //名称
    private String names;
    //内容
    private String content;
    //起始时间
    private Timestamp startTime;
    //终止时间
    private Timestamp endTime;
    //商家(商家账号主键)
    private String businessaccount;
    //活动地址
    private String address;
    //批次
    private String batch;
    //行业分类
    private String classification;
    //状态 0:尚未开启，1:正在进行，2:已经结束
    private Integer type;

    public Activity() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getBusinessaccount() {
        return businessaccount;
    }

    public void setBusinessaccount(String businessaccount) {
        this.businessaccount = businessaccount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Activity(String uuid, String names, String content, Timestamp startTime, Timestamp endTime, String businessaccount, String address, String batch, String classification, Integer type) {
        this.uuid = uuid;
        this.names = names;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.businessaccount = businessaccount;
        this.address = address;
        this.batch = batch;
        this.classification = classification;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "uuid='" + uuid + '\'' +
                ", names='" + names + '\'' +
                ", content='" + content + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", businessaccount='" + businessaccount + '\'' +
                ", address='" + address + '\'' +
                ", batch='" + batch + '\'' +
                ", classification='" + classification + '\'' +
                ", type=" + type +
                '}';
    }
}
