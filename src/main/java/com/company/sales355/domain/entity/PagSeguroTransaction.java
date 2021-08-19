package com.company.sales355.domain.entity;

public class PagSeguroTransaction {

    private final String code;
    private final int grossAmmount;
    private int status;

    public PagSeguroTransaction(String code, int grossAmmount, int status){
        this.code = code;
        this.grossAmmount = grossAmmount;
        this.status = status;
    }
}
