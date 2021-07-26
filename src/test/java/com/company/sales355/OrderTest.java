package com.company.sales355;

import com.company.sales355.domain.Bag;
import com.company.sales355.domain.DocumentIdentification;
import com.company.sales355.domain.Order;
import com.company.sales355.domain.Producto;
import com.company.sales355.service.OrderService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class OrderTest {

    @Test
    public void NotOrderCheckedWithCFPInvalid(){
        OrderService orderService = new OrderService();
        Bag bag = orderService.createBagOrder(new Producto("Tshirt", new BigDecimal("10.00"), 10));
        Order order = orderService.createOrder(new DocumentIdentification("42036080820"), bag);
        assertTrue(orderService.ValidDocumentIdentificationIntoOrder(order));
    }

//    @Test
//    void OrderMustHave3Products(){
//
//    }
//
//    @Test
//    void OrderWithCupomSale(){
//
//    }



}
