package com.company.sales355.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public BigDecimal freight;
    private final Cpf cpf;
    private final List<OrderItem> itens;
    private Cupom cupom;

    public Order(Cpf cpf) {
        this.cpf = cpf;
        this.itens = new ArrayList<>();
        this.freight = BigDecimal.ZERO;
    }

    public Order(Cpf cpf, OrderItem orderItem) {
        this.itens = new ArrayList<>();
        itens.add(orderItem);
        this.cpf = cpf;
        this.freight = BigDecimal.ZERO;
    }

    public Order(Cpf cpf, List<OrderItem> orderItem) {
        this.itens = orderItem;
        this.cpf = cpf;
        this.freight = BigDecimal.ZERO;
    }

    public String getCpf() {
        return this.cpf.getDocument();
    }

    public void setOrderItem(OrderItem orderItem) {
        this.itens.add(orderItem);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem oi : itens) {
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

    public List<OrderItem> getItens() {
        return itens;
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