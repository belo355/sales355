package com.company.sales355.application.getOrder;

import com.company.sales355.application.placeOrder.PlaceOrderCheckoutDTO;
import com.company.sales355.application.placeOrder.PlaceOrderDTO;
import com.company.sales355.domain.gateway.memory.ZipCodeCalculatorApi;
import com.company.sales355.domain.repository.CouponRepository;
import com.company.sales355.domain.repository.ItemRepository;
import com.company.sales355.domain.repository.OrderRepository;

public class GetOrderCU {

    private final ItemRepository itemRepository;
    private final CouponRepository couponRepository;
    private final OrderRepository orderRepository;

    public GetOrderCU(ItemRepository itemRepository, CouponRepository couponRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.couponRepository = couponRepository;
        this.orderRepository = orderRepository;
    }

    public PlaceOrderCheckoutDTO execute(PlaceOrderDTO placeOrderDTO) {

    }

}
