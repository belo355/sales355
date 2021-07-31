package com.company.sales355.service;

import com.company.sales355.entity.CPF;
import com.company.sales355.entity.Cupom;
import com.company.sales355.entity.Order;
import com.company.sales355.entity.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaceOrder {

    private List<Cupom> cupomsDisponiveis = new ArrayList<>();

    public PlaceOrder() {
        cupomsDisponiveis.add(new Cupom("VALE20", 20));
    }

    public BigDecimal execute(PlaceOrderDTO placeOrderDTO) {
        Order order = new Order(new CPF(placeOrderDTO.getCpf().getDocument()));
        for (OrderItem item: placeOrderDTO.getItems()){
            order.setOrderItem(item);
        }
        if(!placeOrderDTO.getCupom().getCode().isEmpty()){
            Optional<Boolean> hasCupom = cupomsDisponiveis.stream().map(cupom -> cupom.getCode().equals(placeOrderDTO.getCupom())).findFirst(); //TODO: RETORNAR O CUPOM
            if(hasCupom.isPresent()){
                order.addCupom(placeOrderDTO.getCupom().getCode(), placeOrderDTO.getCupom().getPercentage());
            }
        }
       return order.getTotal();
    }
}
