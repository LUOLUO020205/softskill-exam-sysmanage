package com.softskill.exam.domain;

import java.util.Date;

public class DailyExam {
    private Long cDeId;

    private String cDeName;

    private Date cDeDate;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcDeId() {
        return cDeId;
    }

    public void setcDeId(Long cDeId) {
        this.cDeId = cDeId;
    }

    public String getcDeName() {
        return cDeName;
    }

    public void setcDeName(String cDeName) {
        this.cDeName = cDeName == null ? null : cDeName.trim();
    }

    public Date getcDeDate() {
        return cDeDate;
    }

    public void setcDeDate(Date cDeDate) {
        this.cDeDate = cDeDate;
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