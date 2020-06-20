package com.softskill.exam.domain;

import java.util.Date;

public class Permission {
    private Long cPermId;

    private String cPermName;

    private String cPermType;

    private String cPermUrl;

    private Long cPermPid;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcPermId() {
        return cPermId;
    }

    public void setcPermId(Long cPermId) {
        this.cPermId = cPermId;
    }

    public String getcPermName() {
        return cPermName;
    }

    public void setcPermName(String cPermName) {
        this.cPermName = cPermName == null ? null : cPermName.trim();
    }

    public String getcPermType() {
        return cPermType;
    }

    public void setcPermType(String cPermType) {
        this.cPermType = cPermType == null ? null : cPermType.trim();
    }

    public String getcPermUrl() {
        return cPermUrl;
    }

    public void setcPermUrl(String cPermUrl) {
        this.cPermUrl = cPermUrl == null ? null : cPermUrl.trim();
    }

    public Long getcPermPid() {
        return cPermPid;
    }

    public void setcPermPid(Long cPermPid) {
        this.cPermPid = cPermPid;
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