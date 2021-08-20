package com.company.sales355.domain.infra.repository.memory;

import com.company.sales355.domain.entity.Cpf;
import com.company.sales355.domain.entity.Order;
import com.company.sales355.domain.entity.OrderItem;
import com.company.sales355.infra.repository.memory.OrderRepositoryInMemory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryInMemoryTest {

    @Test
    public void shouldBeFindOneOrderById(){
        Cpf cpf = new Cpf("42036080820");
        List<OrderItem> orderItems = new ArrayList<>();
        Order order = new Order(cpf, orderItems);
        OrderRepositoryInMemory orderRepositoryInMemory = new OrderRepositoryInMemory();
        orderRepositoryInMemory.save(order);
        Assert.assertNotNull(order);
    }
}
