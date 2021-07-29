package com.company.sales355.entity;

import java.math.BigDecimal;

public class OrderItem {

    private String description;
    private BigDecimal value;
    private double quantity;

    public OrderItem(String description, BigDecimal value, double quantity) {
        this.description = description;
        this.value = value;
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
         return this.value.multiply(BigDecimal.valueOf(this.quantity));
    }

}
