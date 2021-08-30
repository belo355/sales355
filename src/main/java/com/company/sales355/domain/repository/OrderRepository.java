package com.company.sales355.domain.repository;

import com.company.sales355.domain.entity.Order;

public interface OrderRepository {
    void save(Order order);
    Order getByCode(String code);
}
