package com.company.sales355.infra.repository.memory;

import com.company.sales355.domain.entity.Order;
import com.company.sales355.domain.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryInMemory implements OrderRepository {
    List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        this.orders.add(order);
    }

    @Override
    public Order getByCode(String code) {
        Optional<Order> order = orders.stream().filter(o -> o.equals(code)).findFirst();
        if(order.isPresent()){
            return order.get();
        }
        return null;
    }
}
