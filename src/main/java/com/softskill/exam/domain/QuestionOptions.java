package com.softskill.exam.domain;

import java.util.Date;

public class QuestionOptions {
    private Long cQoId;

    private Long cQuesId;

    private String cQoContent;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcQoId() {
        return cQoId;
    }

    public void setcQoId(Long cQoId) {
        this.cQoId = cQoId;
    }

    public Long getcQuesId() {
        return cQuesId;
    }

    public void setcQuesId(Long cQuesId) {
        this.cQuesId = cQuesId;
    }

    public String getcQoContent() {
        return cQoContent;
    }

    public void setcQoContent(String cQoContent) {
        this.cQoContent = cQoContent == null ? null : cQoContent.trim();
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