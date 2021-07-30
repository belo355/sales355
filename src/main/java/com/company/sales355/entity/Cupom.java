package com.company.sales355.entity;

public class Cupom {
    String code;
    double percentage;

    public Cupom(String code, int percentage) {
        this.code = code;
        this.percentage= percentage;
    }

    public double getPercentage() {
        return this.percentage;
    }
}
