package org.customer.com.volume.model;

import java.sql.Timestamp;

/**
 * @name 用户领卷记录
 * @table volume_table
 */
public class VolumeModel {
    //    uuid
    private String uuid;
    //    accountId
    private String accountId;
    //    活动
    private String activity;
    //    卷类型
    private String typeId;
    //    卷编号
    private String number;
    //    卷领取时间
    private Timestamp receiveTimes;
    //    卷是否使用
    private String use;
    //    卷使用时间
    private Timestamp useTimes;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Timestamp getReceiveTimes() {
        return (Timestamp) receiveTimes.clone();
    }

    public void setReceiveTimes(Timestamp receiveTimes) {
        this.receiveTimes = receiveTimes == null ? new Timestamp(System.currentTimeMillis()) : receiveTimes;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public Timestamp getUseTimes() {
        return (Timestamp) useTimes.clone();
    }

    public void setUseTimes(Timestamp useTimes) {
        this.useTimes = useTimes == null ? new Timestamp(System.currentTimeMillis()) : useTimes;
    }

    public VolumeModel() {
        super();
    }

    public VolumeModel(String uuid,
                       String accountId,
                       String activity,
                       String typeId,
                       String number,
                       Timestamp receiveTimes,
                       String use,
                       Timestamp useTimes) {
        this.uuid = uuid;
        this.accountId = accountId;
        this.activity = activity;
        this.typeId = typeId;
        this.number = number;
        this.receiveTimes = receiveTimes == null ? new Timestamp(System.currentTimeMillis()) : receiveTimes;
        this.use = use;
        this.useTimes = useTimes == null ? new Timestamp(System.currentTimeMillis()) : useTimes;
    }

    @Override
    public String toString() {
        return "VolumeModel{" +
                "uuid='" + uuid + '\'' +
                ", accountId='" + accountId + '\'' +
                ", activity='" + activity + '\'' +
                ", typeId='" + typeId + '\'' +
                ", number='" + number + '\'' +
                ", receiveTimes=" + receiveTimes +
                ", use='" + use + '\'' +
                ", useTimes=" + useTimes +
                '}';
    }
}
