package com.company.sales355.entity;

import java.time.LocalDate;

public class Cupom {
    private final LocalDate expireDate;
    private String code;
    private double percentage;

    public Cupom(String code, double percentage, LocalDate expireDate) {
        this.code = code;
        this.percentage = percentage;

        if(isExpired(expireDate)){
            throw new Error("não é possivel inserir cupom vencido");
        }
        this.expireDate = expireDate;
    }

    private boolean isExpired(LocalDate expireDate) {
        return expireDate.isBefore(LocalDate.now());
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
