package com.softskill.exam.domain;

import java.util.Date;

public class ErrorFavorites {
    private Long cEfId;

    private Long cUid;

    private Integer cEfTotalNum;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcEfId() {
        return cEfId;
    }

    public void setcEfId(Long cEfId) {
        this.cEfId = cEfId;
    }

    public Long getcUid() {
        return cUid;
    }

    public void setcUid(Long cUid) {
        this.cUid = cUid;
    }

    public Integer getcEfTotalNum() {
        return cEfTotalNum;
    }

    public void setcEfTotalNum(Integer cEfTotalNum) {
        this.cEfTotalNum = cEfTotalNum;
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