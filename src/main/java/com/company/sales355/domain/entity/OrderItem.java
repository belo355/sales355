package com.company.sales355.domain.entity;

import java.math.BigDecimal;

public class OrderItem {

    private final String id;
    private final BigDecimal price;
    private final int quantity;

    public OrderItem(String id, BigDecimal price,  int quantity) {
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

    public int getQuantity() {
        return quantity;
    }
}
