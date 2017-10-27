package com.cjrj.edu.entity.vo;

import java.math.BigDecimal;
import java.util.List;

public class ActiviUser {
    private BigDecimal userId;

    private String username;

    private String password;

    private String email;

    private BigDecimal deptid;

    private BigDecimal locked;

    private List<MenuVO> tree;

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getDeptid() {
        return deptid;
    }

    public void setDeptid(BigDecimal deptid) {
        this.deptid = deptid;
    }

    public BigDecimal getLocked() {
        return locked;
    }

    public void setLocked(BigDecimal locked) {
        this.locked = locked;
    }

    public List<MenuVO> getTree() {
        return tree;
    }

    public void setTree(List<MenuVO> tree) {
        this.tree = tree;
    }
}
