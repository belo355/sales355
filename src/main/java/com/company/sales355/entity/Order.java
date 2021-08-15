package com.company.sales355.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public BigDecimal freight;
    private final Cpf cpf;
    private final List<OrderItem> items;
    private Cupom cupom;

    public Order(Cpf cpf) {
        this.cpf = cpf;
        this.items = new ArrayList<>();
        this.freight = BigDecimal.ZERO;
    }

    public Order(Cpf cpf, OrderItem orderItem) {
        this.items = new ArrayList<>();
        items.add(orderItem);
        this.cpf = cpf;
        this.freight = BigDecimal.ZERO;
    }

    public Order(Cpf cpf, List<OrderItem> orderItem) {
        this.items = orderItem;
        this.cpf = cpf;
        this.freight = BigDecimal.ZERO;
    }

    public String getCpf() {
        return this.cpf.getDocument();
    }

    public void setOrderItem(OrderItem orderItem) {
        this.items.add(orderItem);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem oi : items) {
            total = total.add(oi.getTotal());
        }
        if (this.cupom != null) {
            return total.subtract(total.multiply(BigDecimal.valueOf(cupom.getPercentage())).divide(new BigDecimal("100")));
        }
        total = total.add(this.freight);
        return total;
    }

    public void addCupom(Cupom cupom) {
        if (!cupom.isExpired()) {
            this.cupom = cupom;
        }
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = this.freight.add(freight);
    }

    public BigDecimal getFreight() {
        return this.freight;
    }
}