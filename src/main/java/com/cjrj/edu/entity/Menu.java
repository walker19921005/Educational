package com.cjrj.edu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Menu implements Serializable {
    private BigDecimal menuId;

    private String menuName;

    private BigDecimal parentid;

    private BigDecimal sequences;

    private String menuIcon;

    private String menuUrl;

    private BigDecimal enable;

    private Date createdate;

    private String createname;

    private Date modifydate;

    private String modifyname;

    private BigDecimal delFlag;

    private static final long serialVersionUID = 1L;

    public BigDecimal getMenuId() {
        return menuId;
    }

    public void setMenuId(BigDecimal menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public BigDecimal getParentid() {
        return parentid;
    }

    public void setParentid(BigDecimal parentid) {
        this.parentid = parentid;
    }

    public BigDecimal getSequences() {
        return sequences;
    }

    public void setSequences(BigDecimal sequences) {
        this.sequences = sequences;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public BigDecimal getEnable() {
        return enable;
    }

    public void setEnable(BigDecimal enable) {
        this.enable = enable;
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