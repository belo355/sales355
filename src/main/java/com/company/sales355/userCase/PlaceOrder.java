package com.company.sales355.userCase;

import com.company.sales355.entity.*;

import java.math.BigDecimal;
import java.util.Optional;

public class PlaceOrder {

    private final ItemRepository itemRepository;
    private final CouponRepository couponRepository;

    private final ZipCodeCalculatorApiMemory zipCodeCalculator = new ZipCodeCalculatorApiMemory();

    public PlaceOrder(ItemRepository itemRepository, CouponRepository couponRepository) {
        this.itemRepository = itemRepository;
        this.couponRepository = couponRepository;
    }

    public PlaceOrderOutputDTO execute(PlaceOrderInputDTO placeOrderInputDTO) {
        Order order = new Order(new Cpf(placeOrderInputDTO.getCpf()));
        int distance = this.zipCodeCalculator.calculate(placeOrderInputDTO.getZipCode(), "99.999-99");
        for (OrderItem item : placeOrderInputDTO.getItems()) {
            Optional<Item> hasItemRepository = this.itemRepository.findById(item.getId());
            if(!hasItemRepository.isPresent()){
                throw new Error("Item not found");
            }
            order.setOrderItem(new OrderItem(item.getId(), hasItemRepository.get().getPrice(), item.getQuantity()));
            FreightCalculator freightCalculator = new FreightCalculator();
            double amountFreight = freightCalculator.calculate(distance, hasItemRepository.get()   );
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
        Optional<Coupon> hasCupom = couponRepository.findById(placeOrderInputDTO.getCupom());
        hasCupom.ifPresent(cupom -> order.addCupom(new Coupon(placeOrderInputDTO.getCupom(), cupom.getPercentage(), cupom.getExpireDate())));
    }
}
