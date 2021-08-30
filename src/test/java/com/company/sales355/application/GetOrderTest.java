package com.company.sales355.application;

import com.company.sales355.domain.entity.Coupon;
import com.company.sales355.domain.entity.Cpf;
import com.company.sales355.domain.entity.OrderItem;
import com.company.sales355.domain.gateway.memory.ZipCodeCalculatorApi;
import com.company.sales355.domain.repository.CouponRepository;
import com.company.sales355.domain.repository.ItemRepository;
import com.company.sales355.domain.repository.OrderRepository;
import com.company.sales355.infra.gateway.memory.ZipCodeCalculatorApiApiMemory;
import com.company.sales355.infra.repository.memory.CouponRepositoryInMemory;
import com.company.sales355.infra.repository.memory.ItemRepositoryInMemory;
import com.company.sales355.infra.repository.memory.OrderRepositoryInMemory;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetOrderTest {

    @Test
    public void shouldBeFindOrderExists() {
        Cpf cpf = new Cpf("42036080820");
        List<OrderItem> orderItems = new ArrayList<>();
        String zipCode = "11.111-11";
        orderItems.add(new OrderItem("1", new BigDecimal("1000"), 2));
        orderItems.add(new OrderItem("2", new BigDecimal("5000"),  1));
        orderItems.add(new OrderItem("3", new BigDecimal("1000"), 3));
        Coupon coupon = new Coupon("VALE20", 20, LocalDate.now());
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO(cpf.getDocument(), orderItems, coupon.getCode(), zipCode);
        ItemRepository itemRepository = new ItemRepositoryInMemory();
        CouponRepository couponRepository = new CouponRepositoryInMemory();
        OrderRepository orderRepository = new OrderRepositoryInMemory();
        ZipCodeCalculatorApi zipCodeCalculatorApi = new ZipCodeCalculatorApiApiMemory();
        PlaceOrder placeOrder = new PlaceOrder(itemRepository, couponRepository, orderRepository, zipCodeCalculatorApi);
        PlaceOrderOutputDTO placeOrderOutputDTO = placeOrder.execute(placeOrderDTO);


        assertEquals(placeOrderOutputDTO.getTotal(), new BigDecimal("5672.00").setScale(1));
    }

}
