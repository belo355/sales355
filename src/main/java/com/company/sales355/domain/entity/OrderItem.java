package com.company.sales355.domain.entity;

import java.math.BigDecimal;

public class OrderItem {

    private final String id;
    private final BigDecimal price;
    private final int quantity;
    private String codeOrder;

    public OrderItem(String id, BigDecimal price,  int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.codeOrder = "";
    }
 public OrderItem(String id, BigDecimal price,  int quantity, String codeOrder) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.codeOrder = codeOrder;
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

    public String getCodeOrder() {
        return codeOrder;
    }
}
