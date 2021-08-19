package com.company.sales355.infra.repository.memory;

import com.company.sales355.domain.entity.Order;
import com.company.sales355.domain.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryInMemory implements OrderRepository {
    List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        this.orders.add(order);
    }
}
