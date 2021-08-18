package com.company.sales355.userCase;

import com.company.sales355.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryInMemory implements OrderRepository{
    List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        this.orders.add(order);
    }
}
