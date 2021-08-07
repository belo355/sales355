package com.company.sales355;

import com.company.sales355.entity.CPF;
import com.company.sales355.entity.Cupom;
import com.company.sales355.entity.OrderItem;
import com.company.sales355.userCase.PlaceOrderInputDTO;
import com.company.sales355.userCase.PlaceOrder;
import com.company.sales355.userCase.PlaceOrderOutputDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PlaceOrderTest {

    @Test
    public void deveFazerCriacaoDePedido(){
        PlaceOrder placeOrder = new PlaceOrder();
        CPF cpf = new CPF("42036080820");
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Guitarra", new BigDecimal("1000"), 2));
        orderItems.add(new OrderItem("Amplificador", new BigDecimal("5000"), 1));
        orderItems.add(new OrderItem("Cabo", new BigDecimal("30"), 3));
        Cupom cupom = new Cupom("VALE20", 20, LocalDate.now());
        PlaceOrderInputDTO placeOrderInputDTO = new PlaceOrderInputDTO(cpf.getDocument(), orderItems, cupom.getCode());
        PlaceOrderOutputDTO totalPedido = placeOrder.execute(placeOrderInputDTO);
        assertEquals(totalPedido.getTotal(), new BigDecimal("5672.00"));
    }

    @Test
    public void naoDeveFazerPedidosComCupomExpirado() {
        PlaceOrder placeOrder = new PlaceOrder();
        CPF cpf = new CPF("42036080820");
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Guitarra", new BigDecimal("1000"), 2));
        orderItems.add(new OrderItem("Amplificador", new BigDecimal("5000"), 1));
        orderItems.add(new OrderItem("Cabo", new BigDecimal("30"), 3));
        try {
            Cupom cupom = new Cupom("VALE20", 20, LocalDate.of(2021, 01, 01));
        } catch (Error e) {
            assertEquals("não é possivel inserir cupom vencido", e.getMessage());
        }
    }
}
