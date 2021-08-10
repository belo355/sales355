package com.company.sales355.userCase;

import com.company.sales355.entity.CPF;
import com.company.sales355.entity.Cupom;
import com.company.sales355.entity.Order;
import com.company.sales355.entity.OrderItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaceOrder {

    private List<Cupom> cupomsDisponiveis = new ArrayList<>();

    public PlaceOrder() {
        cupomsDisponiveis.add(new Cupom("VALE20", 20, LocalDate.now()));
        cupomsDisponiveis.add(new Cupom("VALE20_EXPIRED", 20, LocalDate.of(2020, 01, 01)));
    }

    public PlaceOrderOutputDTO execute(PlaceOrderInputDTO placeOrderInputDTO) {
        PlaceOrderOutputDTO outputDTO = new PlaceOrderOutputDTO();
        Order order = new Order(new CPF(placeOrderInputDTO.getCpf()));
        for (OrderItem item : placeOrderInputDTO.getItems()) {
            order.setOrderItem(item);
        }
        if (!placeOrderInputDTO.getCupom().isEmpty()) {
            Optional<Cupom> hasCupom = cupomsDisponiveis.stream().filter(cupom -> cupom.getCode().equals(placeOrderInputDTO.getCupom())).findFirst();
            hasCupom.ifPresent(cupom -> order.addCupom(new Cupom(placeOrderInputDTO.getCupom(), cupom.getPercentage(), cupom.getExpireDate())));
        }
        outputDTO.setTotal(order.getTotal());
        return outputDTO;
    }
}
