package com.cjrj.edu.entity.vo;

import java.math.BigDecimal;

public class SelectVO {
    private BigDecimal id;

    private String text;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
