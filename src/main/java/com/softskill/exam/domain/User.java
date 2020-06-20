package com.softskill.exam.domain;

import java.util.Date;

public class User {
    private Long cUid;

    private Long cEfId;

    private String cWxid;

    private String cNickName;

    private String cSex;

    private String cHeadImg;

    private String cUserType;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcUid() {
        return cUid;
    }

    public void setcUid(Long cUid) {
        this.cUid = cUid;
    }

    public Long getcEfId() {
        return cEfId;
    }

    public void setcEfId(Long cEfId) {
        this.cEfId = cEfId;
    }

    public String getcWxid() {
        return cWxid;
    }

    public void setcWxid(String cWxid) {
        this.cWxid = cWxid == null ? null : cWxid.trim();
    }

    public String getcNickName() {
        return cNickName;
    }

    public void setcNickName(String cNickName) {
        this.cNickName = cNickName == null ? null : cNickName.trim();
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public String getcHeadImg() {
        return cHeadImg;
    }

    public void setcHeadImg(String cHeadImg) {
        this.cHeadImg = cHeadImg == null ? null : cHeadImg.trim();
    }

    public String getcUserType() {
        return cUserType;
    }

    public void setcUserType(String cUserType) {
        this.cUserType = cUserType == null ? null : cUserType.trim();
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