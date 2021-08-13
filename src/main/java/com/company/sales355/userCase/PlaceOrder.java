package com.company.sales355.userCase;

import com.company.sales355.entity.Order;
import com.company.sales355.entity.Cupom;
import com.company.sales355.entity.Item;
import com.company.sales355.entity.OrderItem;
import com.company.sales355.entity.Cpf;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlaceOrder {

    private List<Cupom> coupons = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public PlaceOrder() {
        coupons.add(new Cupom("VALE20", 20, LocalDate.now()));
        coupons.add(new Cupom("VALE20_EXPIRED", 20, LocalDate.of(2020, 01, 01)));

        items.add(new Item("1", "Guitarra", new BigDecimal("1000"),  100, 50, 15, 3));
        items.add(new Item("2", "Amplificador", new BigDecimal("5000"),  50, 50, 50, 22));
        items.add(new Item("3", "Cabo", new BigDecimal("30"), 10 , 10 , 10, 1));
    }

    public PlaceOrderOutputDTO execute(PlaceOrderInputDTO placeOrderInputDTO) {
        Order order = new Order(new Cpf(placeOrderInputDTO.getCpf()));
        for (OrderItem item : placeOrderInputDTO.getItems()) {
            List<Item> itemsRepo = this.items.stream().filter(i -> i.getId().equals(item.getId())).collect(Collectors.toList());
            if(itemsRepo.isEmpty()){
                throw new Error("Item not found");
            }
            order.setOrderItem(new OrderItem(item.getId(), itemsRepo.get(0).getPrice(), item.getQuantity()));
        }
        if (!placeOrderInputDTO.getCupom().isEmpty()) {
            Optional<Cupom> hasCupom = coupons.stream().filter(cupom -> cupom.getCode().equals(placeOrderInputDTO.getCupom())).findFirst();
            hasCupom.ifPresent(cupom -> order.addCupom(new Cupom(placeOrderInputDTO.getCupom(), cupom.getPercentage(), cupom.getExpireDate())));
        }
        PlaceOrderOutputDTO outputDTO = new PlaceOrderOutputDTO();
        outputDTO.setTotal(order.getTotal());
        return outputDTO;
    }
}
