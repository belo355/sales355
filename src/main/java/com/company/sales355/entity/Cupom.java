package com.company.sales355.entity;

import java.time.LocalDate;

public class Cupom {
    private String code;
    private double percentage;
    private LocalDate expireDate;

    public Cupom(String code, double percentage, LocalDate expireDate) {
        this.code = code;
        this.percentage = percentage;
        this.expireDate = expireDate;
//        if(isExpired()){
//            throw new Error("não é possivel inserir cupom vencido");
//        }
    }

    public boolean isExpired() {
        return this.expireDate.isBefore(LocalDate.now());
    }

    public double getPercentage() {
        return this.percentage;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
}
