package com.softskill.exam.domain;

import java.util.Date;

public class ExamPlace {
    private Long cEpId;

    private Long cChId;

    private String cEpName;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcEpId() {
        return cEpId;
    }

    public void setcEpId(Long cEpId) {
        this.cEpId = cEpId;
    }

    public Long getcChId() {
        return cChId;
    }

    public void setcChId(Long cChId) {
        this.cChId = cChId;
    }

    public String getcEpName() {
        return cEpName;
    }

    public void setcEpName(String cEpName) {
        this.cEpName = cEpName == null ? null : cEpName.trim();
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public Date getcUpdateTime() {
        return cUpdateTime;
    }

    public void setcUpdateTime(Date cUpdateTime) {
        this.cUpdateTime = cUpdateTime;
    }
}