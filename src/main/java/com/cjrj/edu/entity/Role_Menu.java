package com.cjrj.edu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Role_Menu implements Serializable {
    private BigDecimal id;

    private BigDecimal roleid;

    private BigDecimal menuid;

    private Date createdate;

    private String createname;

    private Date modifydate;

    private String modifyname;

    private BigDecimal delFlag;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getRoleid() {
        return roleid;
    }

    public void setRoleid(BigDecimal roleid) {
        this.roleid = roleid;
    }

    public BigDecimal getMenuid() {
        return menuid;
    }

    public void setMenuid(BigDecimal menuid) {
        this.menuid = menuid;
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
}