package com.softskill.exam.domain;

import java.util.Date;

public class QuestionDiscuss {
    private Long cQdId;

    private Long cUid;

    private Long cQuesId;

    private String cQdContent;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcQdId() {
        return cQdId;
    }

    public void setcQdId(Long cQdId) {
        this.cQdId = cQdId;
    }

    public Long getcUid() {
        return cUid;
    }

    public void setcUid(Long cUid) {
        this.cUid = cUid;
    }

    public Long getcQuesId() {
        return cQuesId;
    }

    public void setcQuesId(Long cQuesId) {
        this.cQuesId = cQuesId;
    }

    public String getcQdContent() {
        return cQdContent;
    }

    public void setcQdContent(String cQdContent) {
        this.cQdContent = cQdContent == null ? null : cQdContent.trim();
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