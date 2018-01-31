package org.customer.com.model;

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
    //    卷id
    private String volumeId;
    //    领取时间
    private Timestamp times;

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

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }

    public VolumeModel() {
        super();
    }

    public VolumeModel(String uuid, String accountId, String volumeId, Timestamp times) {
        this.uuid = uuid;
        this.accountId = accountId;
        this.volumeId = volumeId;
        this.times = times;
    }

    @Override
    public String toString() {
        return "VolumeModel{" +
                "uuid='" + uuid + '\'' +
                ", accountId='" + accountId + '\'' +
                ", volumeId='" + volumeId + '\'' +
                ", times=" + times +
                '}';
    }
}
