package com.company.sales355.domain.entity;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    @Test
    public void notOrderCheckedWithCFPInvalid() {
        Cpf cpf = new Cpf("42036080820");
        OrderItem orderItem = new OrderItem("1", new BigDecimal("1000"),1);
        Order order = new Order(cpf, orderItem);
        assertEquals(order.getCpf(), cpf.getDocument());
    }

    @Test
    public void shouldCreateOrderHaveMust3Items(){
        Cpf cpf = new Cpf("42036080820");
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("1", new BigDecimal("1000"),1));
        orderItems.add(new OrderItem("2", new BigDecimal("5000"),1));
        orderItems.add(new OrderItem("3", new BigDecimal("30"),1));
        Order order = new Order(cpf, orderItems);
        assertTrue(order.getItems().size() >= 3);
    }

    @Test
    public void shouldCreateOrderWithCupomSale(){
        Cpf cpf = new Cpf("42036080820");
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("1", new BigDecimal("1000"),1));
        orderItems.add(new OrderItem("2", new BigDecimal("5000"),1));
        Order order = new Order(cpf, orderItems);
        order.addCupom(new Coupon("VALE20", 20, LocalDate.now()));
        assertEquals(new BigDecimal("4800.00").setScale(1),  order.getTotal());
    }

    @Test
    public void shouldNotCreateOrderWithCupomExpired(){
        Cpf cpf = new Cpf("42036080820");
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("1", new BigDecimal("1000"),1));
        orderItems.add(new OrderItem("2", new BigDecimal("5000"),1));
        Order order = new Order(cpf, orderItems);
        order.addCupom(new Coupon("VALE20", 20, LocalDate.of(2020, 10, 1)));
        assertEquals(new BigDecimal("6000"),  order.getTotal());
    }

    @Test
    public void shouldBeCreateOrderWithCodeIdentification(){
        Cpf cpf = new Cpf("42036080820");
        OrderItem item1 = new OrderItem("1", new BigDecimal("1000"),1, "20210101000001");
        OrderItem item2 = new OrderItem("2", new BigDecimal("5000"),1, "20210101000001");
        Order order = new Order(cpf, "20210101000001");
        order.setOrderItem(item1);
        order.setOrderItem(item2);
        order.addCupom(new Coupon("VALE20", 20, LocalDate.of(2020, 10, 1)));
        assertEquals(new BigDecimal("6000"),  order.getTotal());
    }
}
