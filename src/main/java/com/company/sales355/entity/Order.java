package com.company.sales355.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private CPF cpf;
    private List<OrderItem> itens;

    public Order(CPF cpf){
        this.cpf = cpf;
        this.itens = new ArrayList<OrderItem>();
    }

    public Order(CPF cpf, OrderItem orderItem){
        this.itens = new ArrayList<OrderItem>();
        itens.add(orderItem);
        this.cpf = cpf;
    }

    public Order(CPF cpf, List<OrderItem> orderItem){
        this.itens = orderItem;
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf.getCpf();
    }

    public void setOrderItem(OrderItem orderItem) {
        this.itens.add(orderItem);
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.itens = orderItem;
    }

    public BigDecimal getTotal(){
        BigDecimal total= BigDecimal.ZERO;
       for(OrderItem oi: itens){
           total = total.add(oi.getTotal());
       }
        return total;
    }
}