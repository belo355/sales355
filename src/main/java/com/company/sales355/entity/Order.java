package com.company.sales355.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public BigDecimal freight;
    private final Cpf cpf;
    private final List<OrderItem> items;
    private Coupon coupon;

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
        if (this.coupon != null) {
            return total.subtract(total.multiply(BigDecimal.valueOf(coupon.getPercentage())).divide(new BigDecimal("100")));
        }
        total = total.add(this.freight);
        return total;
    }

    public void addCupom(Coupon coupon) {
        if (!coupon.isExpired()) {
            this.coupon = coupon;
        }
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Coupon getCupom() {
        return coupon;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = this.freight.add(freight);
    }

    public BigDecimal getFreight() {
        return this.freight;
    }
}