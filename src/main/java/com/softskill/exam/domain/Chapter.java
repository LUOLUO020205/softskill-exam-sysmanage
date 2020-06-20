package com.softskill.exam.domain;


import java.util.Date;

public class Chapter {
    private Long cChId;

    private Long cCourseId;

    private String cChName;

    private Integer cCourseSortnum;

    private Date cCreateTime;

    private Date cUpdateTime;

    private String cCrName;

    public Long getcChId() {
        return cChId;
    }

    public void setcChId(Long cChId) {
        this.cChId = cChId;
    }

    public Long getcCourseId() {
        return cCourseId;
    }

    public void setcCourseId(Long cCourseId) {
        this.cCourseId = cCourseId;
    }

    public String getcChName() {
        return cChName;
    }

    public void setcChName(String cChName) {
        this.cChName = cChName == null ? null : cChName.trim();
    }

    public Integer getcCourseSortnum() {
        return cCourseSortnum;
    }

    public void setcCourseSortnum(Integer cCourseSortnum) {
        this.cCourseSortnum = cCourseSortnum;
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

    public String getcCrName() { return cCrName; }

    public void setcCrName(String cCrName) { this.cCrName = cCrName; }
}