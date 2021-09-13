package com.company.sales355.application.getOrder;

import com.company.sales355.domain.entity.Item;
import com.company.sales355.domain.entity.Order;
import com.company.sales355.domain.entity.OrderItem;
import com.company.sales355.domain.repository.CouponRepository;
import com.company.sales355.domain.repository.ItemRepository;
import com.company.sales355.domain.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetOrderCaseUse {

    private final ItemRepository itemRepository;
    private final CouponRepository couponRepository;
    private final OrderRepository orderRepository;

    public GetOrderCaseUse(ItemRepository itemRepository, CouponRepository couponRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.couponRepository = couponRepository;
        this.orderRepository = orderRepository;
    }

    public GetOrderCheckoutDTO execute(String code) {
        Order order = this.orderRepository.getByCode(code);
        OrderInvoicedItemDTO orderCheckoutItemDTO = new OrderInvoicedItemDTO();
        List<OrderInvoicedItemDTO> orderCheckoutItemDTOS = new ArrayList<>();
        for(OrderItem orderItem: order.getItems()){
            Optional<Item> item = itemRepository.findById(orderItem.getId());
            if(item.isPresent()){
                orderCheckoutItemDTO.setDescription(item.get().getDescription());
                orderCheckoutItemDTO.setPrice(orderItem.getPrice());
                orderCheckoutItemDTO.setQuantity(orderItem.getQuantity());
            }
            orderCheckoutItemDTOS.add(orderCheckoutItemDTO);
        }
        return new GetOrderCheckoutDTO(order.getCode(), order.getFreight(), order.getTotal(), orderCheckoutItemDTOS);
    }

}
