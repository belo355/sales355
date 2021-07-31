package com.company.sales355.entity;

public class Cupom {
    String code;
    double percentage;

    public Cupom(String code, double percentage) {
        this.code = code;
        this.percentage= percentage;
    }

    public double getPercentage() {
        return this.percentage;
    }

    public String getCode() {
        return code;
    }
}
