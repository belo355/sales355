package com.company.sales355;

import com.company.sales355.entity.CPF;
import com.company.sales355.entity.Cupom;
import com.company.sales355.entity.OrderItem;
import com.company.sales355.userCase.PlaceOrderInputDTO;
import com.company.sales355.userCase.PlaceOrder;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaceOrderTest {

    @Test
    public void shouldTakeOrder(){
        PlaceOrder placeOrder = new PlaceOrder();
        CPF cpf = new CPF("42036080820");
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Guitarra", new BigDecimal("1000"), 2));
        orderItems.add(new OrderItem("Amplificador", new BigDecimal("5000"), 1));
        orderItems.add(new OrderItem("Cabo", new BigDecimal("30"), 3));
        Cupom cupom = new Cupom("VALE20", 20);
        PlaceOrderInputDTO placeOrderInputDTO = new PlaceOrderInputDTO(cpf, orderItems, cupom);
        BigDecimal totalPedido = placeOrder.execute(placeOrderInputDTO);
        assertEquals(totalPedido, new BigDecimal("5672.00"));
    }
}
