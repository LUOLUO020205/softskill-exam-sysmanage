package com.softskill.exam.domain;

import java.util.Date;

public class Course {
    private Long cCourseId;

    private String cCourseName;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcCourseId() {
        return cCourseId;
    }

    public void setcCourseId(Long cCourseId) {
        this.cCourseId = cCourseId;
    }

    public String getcCourseName() {
        return cCourseName;
    }

    public void setcCourseName(String cCourseName) {
        this.cCourseName = cCourseName == null ? null : cCourseName.trim();
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