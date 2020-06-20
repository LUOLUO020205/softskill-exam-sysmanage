package com.softskill.exam.domain;

import java.util.Date;

public class Question {
    private Long cQuesId;

    private Long cChId;

    private Long cEpId;

    private String cQuesTitle;

    private String cQuesType;

    private String cIsEnglish;

    private Long cCorrectOptionId;

    private String cCorrectValue;

    private Date cCreateTime;

    private Date cUpdateTime;

    private String cChName;

    private String cEpName;

    public Long getcQuesId() {
        return cQuesId;
    }

    public void setcQuesId(Long cQuesId) {
        this.cQuesId = cQuesId;
    }

    public Long getcChId() {
        return cChId;
    }

    public void setcChId(Long cChId) {
        this.cChId = cChId;
    }

    public Long getcEpId() {
        return cEpId;
    }

    public void setcEpId(Long cEpId) {
        this.cEpId = cEpId;
    }

    public String getcQuesTitle() {
        return cQuesTitle;
    }

    public void setcQuesTitle(String cQuesTitle) {
        this.cQuesTitle = cQuesTitle == null ? null : cQuesTitle.trim();
    }

    public String getcQuesType() {
        return cQuesType;
    }

    public void setcQuesType(String cQuesType) {
        this.cQuesType = cQuesType == null ? null : cQuesType.trim();
    }

    public String getcIsEnglish() {
        return cIsEnglish;
    }

    public void setcIsEnglish(String cIsEnglish) {
        this.cIsEnglish = cIsEnglish == null ? null : cIsEnglish.trim();
    }

    public Long getcCorrectOptionId() {
        return cCorrectOptionId;
    }

    public void setcCorrectOptionId(Long cCorrectOptionId) {
        this.cCorrectOptionId = cCorrectOptionId;
    }

    public String getcCorrectValue() {
        return cCorrectValue;
    }

    public void setcCorrectValue(String cCorrectValue) {
        this.cCorrectValue = cCorrectValue == null ? null : cCorrectValue.trim();
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

    public String getcChName() { return cChName; }

    public void setcChName(String cChName) { this.cChName = cChName; }

    public String getcEpName() { return cEpName; }

    public void setcEpName(String cEpName) { this.cEpName = cEpName; }

}