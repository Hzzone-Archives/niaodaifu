package cn.hzzone.dachuang.model;

import java.util.Date;

public class Records {
    private String recordsId;

    private String openId;

    private String recordType;

    private Date recordsTime;

    public String getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(String recordsId) {
        this.recordsId = recordsId == null ? null : recordsId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType == null ? null : recordType.trim();
    }

    public Date getRecordsTime() {
        return recordsTime;
    }

    public void setRecordsTime(Date recordsTime) {
        this.recordsTime = recordsTime;
    }
}