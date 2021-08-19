package com.company.sales355.application;

import com.company.sales355.domain.entity.*;
import com.company.sales355.domain.repository.CouponRepository;
import com.company.sales355.domain.repository.ItemRepository;
import com.company.sales355.domain.repository.OrderRepository;
import com.company.sales355.domain.services.FreightCalculator;
import com.company.sales355.domain.gateway.memory.ZipCodeCalculatorApi;

import java.math.BigDecimal;
import java.util.Optional;

public class PlaceOrder {

    private final ItemRepository itemRepository;
    private final CouponRepository couponRepository;
    private final OrderRepository orderRepository;
    private final ZipCodeCalculatorApi zipCodeCalculatorApi;

    public PlaceOrder(ItemRepository itemRepository, CouponRepository couponRepository,
                      OrderRepository orderRepository, ZipCodeCalculatorApi zipCodeCalculatorApi) {
        this.itemRepository = itemRepository;
        this.couponRepository = couponRepository;
        this.orderRepository = orderRepository;
        this.zipCodeCalculatorApi = zipCodeCalculatorApi;
    }

    public PlaceOrderOutputDTO execute(PlaceOrderDTO placeOrderDTO) {
        Order order = new Order(new Cpf(placeOrderDTO.getCpf()));
        int distance = this.zipCodeCalculatorApi.calculate(placeOrderDTO.getZipCode(), "99.999-99");
        for (OrderItem item : placeOrderDTO.getItems()) {
            Optional<Item> hasItemRepository = this.itemRepository.findById(item.getId());
            if(!hasItemRepository.isPresent()){
                throw new Error("Item not found");
            }
            order.setOrderItem(new OrderItem(item.getId(), hasItemRepository.get().getPrice(), item.getQuantity()));
            order.setFreight(calculateFreightValue(distance, hasItemRepository, item, new FreightCalculator()));
        }
        if (!placeOrderDTO.getCoupon().isEmpty()) {
            includeCouponIntoOrder(placeOrderDTO, order);
        }
        PlaceOrderOutputDTO outputDTO = new PlaceOrderOutputDTO();
        outputDTO.setTotal(order.getTotal());
        outputDTO.setFreight(order.getFreight());
        orderRepository.save(order);
        return outputDTO;
    }

    private BigDecimal calculateFreightValue(int distance, Optional<Item> hasItemRepository, OrderItem item, FreightCalculator freightCalculator) {
        double amountFreight = freightCalculator.calculate(distance, hasItemRepository.get());
        return BigDecimal.valueOf(amountFreight).multiply(BigDecimal.valueOf(item.getQuantity()));
    }

    private void includeCouponIntoOrder(PlaceOrderDTO placeOrderDTO, Order order) {
        Optional<Coupon> hasCupom = couponRepository.findByCode(placeOrderDTO.getCoupon());
        hasCupom.ifPresent(cupom -> order.addCupom(new Coupon(placeOrderDTO.getCoupon(), cupom.getPercentage(), cupom.getExpireDate())));
    }
}
