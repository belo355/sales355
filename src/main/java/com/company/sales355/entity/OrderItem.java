package com.company.sales355.entity;

import java.math.BigDecimal;

public class OrderItem {

    private String id;
    private BigDecimal price;
    private double quantity;

    public OrderItem(String id, BigDecimal price,  double quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return this.price.multiply(BigDecimal.valueOf(this.quantity));
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }
}
