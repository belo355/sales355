package com.company.sales355.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Cpf cpf;
    private List<OrderItem> itens;
    private Cupom cupom;

    public Order(Cpf cpf){
        this.cpf = cpf;
        this.itens = new ArrayList<>();
    }

    public Order(Cpf cpf, OrderItem orderItem){
        this.itens = new ArrayList<>();
        itens.add(orderItem);
        this.cpf = cpf;
    }

    public Order(Cpf cpf, List<OrderItem> orderItem){
        this.itens = orderItem;
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf.getDocument();
    }

    public void setOrderItem(OrderItem orderItem) {
        this.itens.add(orderItem);
    }

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
       for(OrderItem oi: itens){
           total = total.add(oi.getTotal());
       }
       if(this.cupom != null){
        BigDecimal desconto = total.multiply(BigDecimal.valueOf(cupom.getPercentage())).divide(new BigDecimal("100"));
         return total.subtract(desconto);
       }
        return total;
    }

    public void addCupom(Cupom cupom) {
        if(!cupom.isExpired()){
            this.cupom = cupom;
        }
    }

    public List<OrderItem> getItens() {
        return itens;
    }

    public Cupom getCupom() {
        return cupom;
    }
}