package com.company.sales355.userCase;

import com.company.sales355.entity.CPF;
import com.company.sales355.entity.Cupom;
import com.company.sales355.entity.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaceOrderTest {

    @Test
    public void deveFazerCriacaoDePedido() {
        CPF cpf = new CPF("42036080820");
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Guitarra", new BigDecimal("1000"), 2));
        orderItems.add(new OrderItem("Amplificador", new BigDecimal("5000"), 1));
        orderItems.add(new OrderItem("Cabo", new BigDecimal("30"), 3));
        Cupom cupom = new Cupom("VALE20", 20, LocalDate.now());
        PlaceOrder placeOrder = new PlaceOrder();
        PlaceOrderInputDTO placeOrderInputDTO = new PlaceOrderInputDTO(cpf.getDocument(), orderItems, cupom.getCode());
        PlaceOrderOutputDTO placeOrderOutputDTO = placeOrder.execute(placeOrderInputDTO);
        assertEquals(placeOrderOutputDTO.getTotal(), new BigDecimal("5672.00"));
    }

    @Test
    public void naoDeveFazerPedidosComCupomExpirado() {
        CPF cpf = new CPF("42036080820");
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Guitarra", new BigDecimal("1000"), 2));
        orderItems.add(new OrderItem("Amplificador", new BigDecimal("5000"), 1));
        orderItems.add(new OrderItem("Cabo", new BigDecimal("30"), 3));
        Cupom cupom = new Cupom("VALE20_EXPIRED", 20, LocalDate.of(2020, 01, 01));
        PlaceOrder placeOrder = new PlaceOrder();
        PlaceOrderInputDTO placeOrderInputDTO = new PlaceOrderInputDTO(cpf.getDocument(), orderItems, cupom.getCode());
        PlaceOrderOutputDTO placeOrderOutputDTO = placeOrder.execute(placeOrderInputDTO);
        assertEquals(placeOrderOutputDTO.getTotal(), new BigDecimal("7090.0"));
    }
}
