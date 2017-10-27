package com.cjrj.edu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Student implements Serializable {
    private BigDecimal stuId;

    private BigDecimal userid;

    private String stuName;

    private BigDecimal sex;

    private String stuIphone;

    private String stuPhone;

    private String stuAddress;

    private Date stuBirthday;

    private Date enroldate;

    private Date createdate;

    private String createname;

    private Date modifydate;

    private String modifyname;

    private BigDecimal delFlag;

    private String linkman;

    private String linkmanIphone;

    private Date graduatedate;

    private String icon;

    private BigDecimal classid;

    private static final long serialVersionUID = 1L;

    public BigDecimal getStuId() {
        return stuId;
    }

    public void setStuId(BigDecimal stuId) {
        this.stuId = stuId;
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public BigDecimal getSex() {
        return sex;
    }

    public void setSex(BigDecimal sex) {
        this.sex = sex;
    }

    public String getStuIphone() {
        return stuIphone;
    }

    public void setStuIphone(String stuIphone) {
        this.stuIphone = stuIphone == null ? null : stuIphone.trim();
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public Date getEnroldate() {
        return enroldate;
    }

    public void setEnroldate(Date enroldate) {
        this.enroldate = enroldate;
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

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkmanIphone() {
        return linkmanIphone;
    }

    public void setLinkmanIphone(String linkmanIphone) {
        this.linkmanIphone = linkmanIphone == null ? null : linkmanIphone.trim();
    }

    public Date getGraduatedate() {
        return graduatedate;
    }

    public void setGraduatedate(Date graduatedate) {
        this.graduatedate = graduatedate;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public BigDecimal getClassid() {
        return classid;
    }

    public void setClassid(BigDecimal classid) {
        this.classid = classid;
    }
}