package com.company.sales355;

import com.company.sales355.entity.OrderItem;
import com.company.sales355.entity.CPF;
import com.company.sales355.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    @Test
    public void NotOrderCheckedWithCFPInvalid() {
        CPF cpf = new CPF("42036080820");
        OrderItem orderItem = new OrderItem("Camisa P", new BigDecimal("50"),1);
        Order order = new Order(cpf, orderItem);
        assertEquals(order.getCpf(), cpf.getDocument());
    }

    @Test
    public void ShouldCreateOrderHaveMust3Items(){
        CPF cpf = new CPF("42036080820");
        OrderItem orderItemA = new OrderItem("Camisa P", new BigDecimal("50"),1);
        OrderItem orderItemB = new OrderItem("Camisa M", new BigDecimal("100"),1);
        OrderItem orderItemC = new OrderItem("Camisa G", new BigDecimal("150"),1);
        Order order = new Order(cpf);
        order.setOrderItem(orderItemA);
        order.setOrderItem(orderItemB);
        order.setOrderItem(orderItemC);
        assertEquals(new BigDecimal("300.0"),  order.getTotal());
    }

    @Test
    public void ShouldCreateOrderWithCupomSale(){
        CPF cpf = new CPF("42036080820");
        OrderItem orderItemA = new OrderItem("Camisa P", new BigDecimal("50"),1);
        OrderItem orderItemB = new OrderItem("Camisa M", new BigDecimal("100"),1);
        Order order = new Order(cpf);
        order.setOrderItem(orderItemA);
        order.setOrderItem(orderItemB);
        order.addCupom("VALE20", 20);
        assertEquals(new BigDecimal("120.00"),  order.getTotal());

    }
}
