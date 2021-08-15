package com.company.sales355.userCase;

import com.company.sales355.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlaceOrder {

    private final List<Cupom> coupons = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();
    private zipCodeCalculatorApiMemory zipCodeCalculator = new zipCodeCalculatorApiMemory();

    public PlaceOrder() {
        coupons.add(new Cupom("VALE20", 20, LocalDate.now()));
        coupons.add(new Cupom("VALE20_EXPIRED", 20, LocalDate.of(2020, 1, 1)));

        items.add(new Item("1", "Guitarra", new BigDecimal("1000"),  100, 50, 15, 3));
        items.add(new Item("2", "Amplificador", new BigDecimal("5000"),  50, 50, 50, 22));
        items.add(new Item("3", "Cabo", new BigDecimal("30"), 10 , 10 , 10, 1));
    }

    public PlaceOrderOutputDTO execute(PlaceOrderInputDTO placeOrderInputDTO) {
        Order order = new Order(new Cpf(placeOrderInputDTO.getCpf()));
        int distance = this.zipCodeCalculator.calculate(placeOrderInputDTO.getZipCode(), "99.999-99");
        for (OrderItem item : placeOrderInputDTO.getItems()) {
            List<Item> itemsRepo = this.items.stream().filter(i -> i.getId().equals(item.getId())).collect(Collectors.toList());
            if(itemsRepo.isEmpty()){
                throw new Error("Item not found");
            }
            order.setOrderItem(new OrderItem(item.getId(), itemsRepo.get(0).getPrice(), item.getQuantity()));
            double amountFreight = FreightCalculator.calculate(distance, itemsRepo.get(0));
            order.setFreight(BigDecimal.valueOf(amountFreight).multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        if (!placeOrderInputDTO.getCupom().isEmpty()) {
            includeCouponIntoOrder(placeOrderInputDTO, order);
        }
        PlaceOrderOutputDTO outputDTO = new PlaceOrderOutputDTO();
        outputDTO.setTotal(order.getTotal());
        outputDTO.setFreight(order.getFreight());
        return outputDTO;
    }

    private void includeCouponIntoOrder(PlaceOrderInputDTO placeOrderInputDTO, Order order) {
        Optional<Cupom> hasCupom = coupons.stream().filter(cupom -> cupom.getCode().equals(placeOrderInputDTO.getCupom())).findFirst();
        hasCupom.ifPresent(cupom -> order.addCupom(new Cupom(placeOrderInputDTO.getCupom(), cupom.getPercentage(), cupom.getExpireDate())));
    }
}
