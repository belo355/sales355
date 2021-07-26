package com.company.sales355.domain;

import java.math.BigDecimal;

public class Producto {
   private String description;
   private BigDecimal value;
   private int amount;

    public Producto(String description, BigDecimal value, int amount) {
        this.description = description;
        this.value = value;
        this.amount = amount;
    }
}
