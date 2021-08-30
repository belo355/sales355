package com.company.sales355.application.getOrder;

import java.math.BigDecimal;

public class OrderInvoicedItemDTO {

    private String description;
    private BigDecimal price;
    private int quantity;


    public OrderInvoicedItemDTO(){
        this.description = "";
        this.price = BigDecimal.ZERO;
        this.quantity = 0;
    }
    public OrderInvoicedItemDTO(String description, BigDecimal price, int quantity){
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
