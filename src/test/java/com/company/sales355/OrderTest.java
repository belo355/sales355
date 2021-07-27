package com.company.sales355;

import com.company.sales355.domain.Bag;
import com.company.sales355.domain.DocumentIdentification;
import com.company.sales355.domain.Order;
import com.company.sales355.domain.Producto;
import com.company.sales355.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void NotOrderCheckedWithCFPInvalid(){
        Bag bag = new Bag();
        Producto producto = new Producto("Tshirt", new BigDecimal("10.00"), 10);
        bag.addProducto(producto);
        assertTrue(orderService.ValidDocumentIdentificationIntoOrder(
                    orderService.createOrder(new DocumentIdentification("42036080820"), bag)));
    }

    @Test
    public void OrderMustHave3Products() {
        List<Producto> productoList = null;
        Producto producto1 = new Producto("Tshirt-P", new BigDecimal("10.00"), 18);   //TODO: fazer uma rotina para criacao de pedidos automaticos por quantidade
        productoList.add(producto1);
        Producto producto2 = new Producto("Tshirt-M", new BigDecimal("59.00"), 4);
        productoList.add(producto2);
        Producto producto3 = new Producto("Tshirt-G", new BigDecimal("70.00"), 10);
        productoList.add(producto3);
        Producto producto4 = new Producto("Tshirt-G", new BigDecimal("9.00"), 1);
        productoList.add(producto4);
        Bag bag = new Bag(productoList);
        Order order = orderService.createOrder(new DocumentIdentification("42036080820"), bag);
        assertTrue(validaOrderMustHave3Products(order));
    }

    private boolean validaOrderMustHave3Products(Order order) {
        Bag bag = (Bag) order.getBag();
        return bag.getProductoList().size() >= 3;
    }

//    @Test
//    void OrderWithCupomSale(){
//
//    }



}
