package com.softskill.exam.domain;

import java.util.Date;

public class HistoryActualCombat {
    private Long cHacId;

    private String cHacName;

    private Date cHacDate;

    private String cHacTime;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcHacId() {
        return cHacId;
    }

    public void setcHacId(Long cHacId) {
        this.cHacId = cHacId;
    }

    public String getcHacName() {
        return cHacName;
    }

    public void setcHacName(String cHacName) {
        this.cHacName = cHacName == null ? null : cHacName.trim();
    }

    public Date getcHacDate() {
        return cHacDate;
    }

    public void setcHacDate(Date cHacDate) {
        this.cHacDate = cHacDate;
    }

    public String getcHacTime() {
        return cHacTime;
    }

    public void setcHacTime(String cHacTime) {
        this.cHacTime = cHacTime == null ? null : cHacTime.trim();
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