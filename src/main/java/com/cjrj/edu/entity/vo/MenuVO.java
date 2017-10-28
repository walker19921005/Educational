package com.cjrj.edu.entity.vo;

import java.math.BigDecimal;
import java.util.List;

public class MenuVO {
    private BigDecimal menuId;

    private String menuName;

    private BigDecimal parentid;

    private BigDecimal sequences;

    private String menuIcon;

    private String menuUrl;

    private BigDecimal enable;

    private List<MenuVO> tree;

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
        this.menuName = menuName;
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
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public BigDecimal getEnable() {
        return enable;
    }

    public void setEnable(BigDecimal enable) {
        this.enable = enable;
    }

    public List<MenuVO> getTree() {
        return tree;
    }

    public void setTree(List<MenuVO> tree) {
        this.tree = tree;
    }
}