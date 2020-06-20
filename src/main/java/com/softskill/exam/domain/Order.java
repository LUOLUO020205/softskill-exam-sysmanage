package com.softskill.exam.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long cOrderId;

    private Long cUid;

    private Long cCourseId;

    private BigDecimal cOrderAmount;

    private String cOrderPayType;

    private Date cPermissionLevel;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcOrderId() {
        return cOrderId;
    }

    public void setcOrderId(Long cOrderId) {
        this.cOrderId = cOrderId;
    }

    public Long getcUid() {
        return cUid;
    }

    public void setcUid(Long cUid) {
        this.cUid = cUid;
    }

    public Long getcCourseId() {
        return cCourseId;
    }

    public void setcCourseId(Long cCourseId) {
        this.cCourseId = cCourseId;
    }

    public BigDecimal getcOrderAmount() {
        return cOrderAmount;
    }

    public void setcOrderAmount(BigDecimal cOrderAmount) {
        this.cOrderAmount = cOrderAmount;
    }

    public String getcOrderPayType() {
        return cOrderPayType;
    }

    public void setcOrderPayType(String cOrderPayType) {
        this.cOrderPayType = cOrderPayType == null ? null : cOrderPayType.trim();
    }

    public Date getcPermissionLevel() {
        return cPermissionLevel;
    }

    public void setcPermissionLevel(Date cPermissionLevel) {
        this.cPermissionLevel = cPermissionLevel;
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