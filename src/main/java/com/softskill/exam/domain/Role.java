package com.softskill.exam.domain;

import java.util.Date;

public class Role {
    private Long cRoleId;

    private String cRoleName;

    private Date cCreateTime;

    private Date cUpdateTime;

    public Long getcRoleId() {
        return cRoleId;
    }

    public void setcRoleId(Long cRoleId) {
        this.cRoleId = cRoleId;
    }

    public String getcRoleName() {
        return cRoleName;
    }

    public void setcRoleName(String cRoleName) {
        this.cRoleName = cRoleName == null ? null : cRoleName.trim();
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