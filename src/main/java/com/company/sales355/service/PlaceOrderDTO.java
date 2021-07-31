package com.company.sales355.service;

import com.company.sales355.entity.CPF;
import com.company.sales355.entity.Cupom;
import com.company.sales355.entity.OrderItem;

import java.util.List;

public class PlaceOrderDTO {

    private CPF cpf;
    private List<OrderItem> items;
    private Cupom cupom;

    public PlaceOrderDTO(CPF cpf, List<OrderItem> items, Cupom cupom) {
        this.cpf = cpf;
        this.items = items;
        this.cupom = cupom;
    }

    public CPF getCpf() {
        return cpf;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Cupom getCupom() {
        return cupom;
    }
}
