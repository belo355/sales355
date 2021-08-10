package com.company.sales355.userCase;

import com.company.sales355.entity.OrderItem;

import java.util.List;

public class PlaceOrderInputDTO {

    private String cpf;
    private List<OrderItem> items;
    private String cupom;

    public PlaceOrderInputDTO(String cpf, List<OrderItem> items, String cupom) {
        this.cpf = cpf;
        this.items = items;
        this.cupom = cupom;
    }

    public PlaceOrderInputDTO(String cpf, List<OrderItem> items) {
        this.cpf = cpf;
        this.items = items;
    }

    public String getCpf() {
        return cpf;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getCupom() {
        return cupom;
    }
}
