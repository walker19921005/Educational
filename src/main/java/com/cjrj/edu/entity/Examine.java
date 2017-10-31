package com.cjrj.edu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Examine implements Serializable {
    private BigDecimal exId;

    private String exCourse;

    private BigDecimal conid;

    private BigDecimal exScore;

    private BigDecimal teachid;

    private String regitname;

    private Date regitdate;

    private String modifyname;

    private Date modifydate;

    private BigDecimal delFlag;

    private BigDecimal stuid;

    private String remark;

    private static final long serialVersionUID = 1L;

    public BigDecimal getExId() {
        return exId;
    }

    public void setExId(BigDecimal exId) {
        this.exId = exId;
    }

    public String getExCourse() {
        return exCourse;
    }

    public void setExCourse(String exCourse) {
        this.exCourse = exCourse == null ? null : exCourse.trim();
    }

    public BigDecimal getConid() {
        return conid;
    }

    public void setConid(BigDecimal conid) {
        this.conid = conid;
    }

    public BigDecimal getExScore() {
        return exScore;
    }

    public void setExScore(BigDecimal exScore) {
        this.exScore = exScore;
    }

    public BigDecimal getTeachid() {
        return teachid;
    }

    public void setTeachid(BigDecimal teachid) {
        this.teachid = teachid;
    }

    public String getRegitname() {
        return regitname;
    }

    public void setRegitname(String regitname) {
        this.regitname = regitname == null ? null : regitname.trim();
    }

    public Date getRegitdate() {
        return regitdate;
    }

    public void setRegitdate(Date regitdate) {
        this.regitdate = regitdate;
    }

    public String getModifyname() {
        return modifyname;
    }

    public void setModifyname(String modifyname) {
        this.modifyname = modifyname == null ? null : modifyname.trim();
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public BigDecimal getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(BigDecimal delFlag) {
        this.delFlag = delFlag;
    }

    public BigDecimal getStuid() {
        return stuid;
    }

    public void setStuid(BigDecimal stuid) {
        this.stuid = stuid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}