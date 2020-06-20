package com.softskill.exam.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ExercisesRecord {
    private Long cErId;

    private Long cUid;

    private String cErType;

    private Long cErQuestionId;

    private Integer cErQuestionNums;

    private Integer cErTrueNums;

    private Integer cErFalseNums;

    private Integer cDerScore;

    private BigDecimal cDerAccuracy;

    private String cResult;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcErId() {
        return cErId;
    }

    public void setcErId(Long cErId) {
        this.cErId = cErId;
    }

    public Long getcUid() {
        return cUid;
    }

    public void setcUid(Long cUid) {
        this.cUid = cUid;
    }

    public String getcErType() {
        return cErType;
    }

    public void setcErType(String cErType) {
        this.cErType = cErType == null ? null : cErType.trim();
    }

    public Long getcErQuestionId() {
        return cErQuestionId;
    }

    public void setcErQuestionId(Long cErQuestionId) {
        this.cErQuestionId = cErQuestionId;
    }

    public Integer getcErQuestionNums() {
        return cErQuestionNums;
    }

    public void setcErQuestionNums(Integer cErQuestionNums) {
        this.cErQuestionNums = cErQuestionNums;
    }

    public Integer getcErTrueNums() {
        return cErTrueNums;
    }

    public void setcErTrueNums(Integer cErTrueNums) {
        this.cErTrueNums = cErTrueNums;
    }

    public Integer getcErFalseNums() {
        return cErFalseNums;
    }

    public void setcErFalseNums(Integer cErFalseNums) {
        this.cErFalseNums = cErFalseNums;
    }

    public Integer getcDerScore() {
        return cDerScore;
    }

    public void setcDerScore(Integer cDerScore) {
        this.cDerScore = cDerScore;
    }

    public BigDecimal getcDerAccuracy() {
        return cDerAccuracy;
    }

    public void setcDerAccuracy(BigDecimal cDerAccuracy) {
        this.cDerAccuracy = cDerAccuracy;
    }

    public String getcResult() {
        return cResult;
    }

    public void setcResult(String cResult) {
        this.cResult = cResult == null ? null : cResult.trim();
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