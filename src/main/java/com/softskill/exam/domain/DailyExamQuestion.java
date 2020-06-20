package com.softskill.exam.domain;

import java.util.Date;

public class DailyExamQuestion {
    private Long cDeId;

    private Long cQuesId;

    private Integer cHqSortnum;

    private Long cHqOptiona;

    private Long cHqOptionb;

    private Long cHqOptionc;

    private Long cHqOptiond;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcDeId() {
        return cDeId;
    }

    public void setcDeId(Long cDeId) {
        this.cDeId = cDeId;
    }

    public Long getcQuesId() {
        return cQuesId;
    }

    public void setcQuesId(Long cQuesId) {
        this.cQuesId = cQuesId;
    }

    public Integer getcHqSortnum() {
        return cHqSortnum;
    }

    public void setcHqSortnum(Integer cHqSortnum) {
        this.cHqSortnum = cHqSortnum;
    }

    public Long getcHqOptiona() {
        return cHqOptiona;
    }

    public void setcHqOptiona(Long cHqOptiona) {
        this.cHqOptiona = cHqOptiona;
    }

    public Long getcHqOptionb() {
        return cHqOptionb;
    }

    public void setcHqOptionb(Long cHqOptionb) {
        this.cHqOptionb = cHqOptionb;
    }

    public Long getcHqOptionc() {
        return cHqOptionc;
    }

    public void setcHqOptionc(Long cHqOptionc) {
        this.cHqOptionc = cHqOptionc;
    }

    public Long getcHqOptiond() {
        return cHqOptiond;
    }

    public void setcHqOptiond(Long cHqOptiond) {
        this.cHqOptiond = cHqOptiond;
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