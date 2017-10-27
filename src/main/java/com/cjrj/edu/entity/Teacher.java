package com.cjrj.edu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Teacher implements Serializable {
    private BigDecimal teachId;

    private BigDecimal userid;

    private String teachName;

    private BigDecimal teachAge;

    private BigDecimal sex;

    private String teachAddress;

    private String teachIphone;

    private String teachDesc;

    private Date entrydate;

    private Date createdate;

    private String createname;

    private Date modifydate;

    private String modifyname;

    private BigDecimal delFlag;

    private Date teachBirthday;

    private String icon;

    private static final long serialVersionUID = 1L;

    public BigDecimal getTeachId() {
        return teachId;
    }

    public void setTeachId(BigDecimal teachId) {
        this.teachId = teachId;
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName == null ? null : teachName.trim();
    }

    public BigDecimal getTeachAge() {
        return teachAge;
    }

    public void setTeachAge(BigDecimal teachAge) {
        this.teachAge = teachAge;
    }

    public BigDecimal getSex() {
        return sex;
    }

    public void setSex(BigDecimal sex) {
        this.sex = sex;
    }

    public String getTeachAddress() {
        return teachAddress;
    }

    public void setTeachAddress(String teachAddress) {
        this.teachAddress = teachAddress == null ? null : teachAddress.trim();
    }

    public String getTeachIphone() {
        return teachIphone;
    }

    public void setTeachIphone(String teachIphone) {
        this.teachIphone = teachIphone == null ? null : teachIphone.trim();
    }

    public String getTeachDesc() {
        return teachDesc;
    }

    public void setTeachDesc(String teachDesc) {
        this.teachDesc = teachDesc == null ? null : teachDesc.trim();
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getModifyname() {
        return modifyname;
    }

    public void setModifyname(String modifyname) {
        this.modifyname = modifyname == null ? null : modifyname.trim();
    }

    public BigDecimal getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(BigDecimal delFlag) {
        this.delFlag = delFlag;
    }

    public Date getTeachBirthday() {
        return teachBirthday;
    }

    public void setTeachBirthday(Date teachBirthday) {
        this.teachBirthday = teachBirthday;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}