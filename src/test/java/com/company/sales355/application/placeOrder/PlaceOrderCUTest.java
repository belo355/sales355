package com.company.sales355.application.placeOrder;

import com.company.sales355.domain.entity.*;
import com.company.sales355.domain.gateway.memory.ZipCodeCalculatorApi;
import com.company.sales355.infra.gateway.memory.ZipCodeCalculatorApiApiMemory;
import com.company.sales355.domain.repository.CouponRepository;
import com.company.sales355.domain.repository.ItemRepository;
import com.company.sales355.domain.repository.OrderRepository;
import com.company.sales355.infra.repository.memory.CouponRepositoryInMemory;
import com.company.sales355.infra.repository.memory.ItemRepositoryInMemory;
import com.company.sales355.infra.repository.memory.OrderRepositoryInMemory;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaceOrderCUTest {

    @Test
    public void shouldBeCreateOrder() {
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
        PlaceOrderCU placeOrderCU = new PlaceOrderCU(itemRepository, couponRepository, orderRepository, zipCodeCalculatorApi);
        PlaceOrderCheckoutDTO placeOrderCheckoutDTO = placeOrderCU.execute(placeOrderDTO);
        assertEquals(placeOrderCheckoutDTO.getTotal(), new BigDecimal("5672.00").setScale(1));
    }

    @Test
    public void shouldNotCreateOrderWithCouponExpired() {
        Cpf cpf = new Cpf("42036080820");
        List<OrderItem> items = new ArrayList<>();
        String zipCode = "11.111-11";
        items.add(new OrderItem("1", new BigDecimal("1000"), 2));
        items.add(new OrderItem("2", new BigDecimal("5000"),1));
        items.add(new OrderItem("3", new BigDecimal("30"),3));
        Coupon coupon = new Coupon("VALE20_EXPIRED", 20, LocalDate.of(2020, 1, 1));
        ItemRepository itemRepository = new ItemRepositoryInMemory();
        CouponRepository couponRepository = new CouponRepositoryInMemory();
        OrderRepository orderRepository = new OrderRepositoryInMemory();
        ZipCodeCalculatorApi zipCodeCalculatorApi = new ZipCodeCalculatorApiApiMemory();
        PlaceOrderCU placeOrderCU = new PlaceOrderCU(itemRepository, couponRepository, orderRepository, zipCodeCalculatorApi);
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO(cpf.getDocument(), items, coupon.getCode(),zipCode);
        PlaceOrderCheckoutDTO placeOrderCheckoutDTO = placeOrderCU.execute(placeOrderDTO);
        assertEquals(placeOrderCheckoutDTO.getTotal(), new BigDecimal("7400.00").setScale(1));
    }

    @Test
    public void shouldNotCreateOrderWithCalculateFreight() {
        Cpf cpf = new Cpf("42036080820");
        List<OrderItem> items = new ArrayList<>();
        String zipCode = "11.111-11";
        items.add(new OrderItem("1", new BigDecimal("1000"), 2));
        items.add(new OrderItem("2", new BigDecimal("5000"),1));
        items.add(new OrderItem("3", new BigDecimal("30"),3));
        Coupon coupon = new Coupon("VALE20_EXPIRED", 20, LocalDate.of(2020, 1, 1));
        ItemRepository itemRepository = new ItemRepositoryInMemory();
        CouponRepository couponRepository = new CouponRepositoryInMemory();
        OrderRepository orderRepository = new OrderRepositoryInMemory();
        ZipCodeCalculatorApi zipCodeCalculatorApi = new ZipCodeCalculatorApiApiMemory();
        PlaceOrderCU placeOrderCU = new PlaceOrderCU(itemRepository, couponRepository, orderRepository, zipCodeCalculatorApi);
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO(cpf.getDocument(), items, coupon.getCode(), zipCode);
        PlaceOrderCheckoutDTO placeOrderCheckoutDTO = placeOrderCU.execute(placeOrderDTO);
        assertEquals(placeOrderCheckoutDTO.getFreight(), new BigDecimal("310.00").setScale(1));
    }

    @Test
    public void shouldBeCreateOrderWithCodeidentification() {
        Cpf cpf = new Cpf("42036080820");
        List<OrderItem> items = new ArrayList<>();
        String zipCode = "11.111-11";
        items.add(new OrderItem("1", new BigDecimal("1000"), 2, "20210101000001"));
        items.add(new OrderItem("2", new BigDecimal("5000"),1, "20210101000001"));
        items.add(new OrderItem("3", new BigDecimal("30"),3, "20210101000001"));
        Coupon coupon = new Coupon("VALE20_EXPIRED", 20, LocalDate.of(2020, 1, 1));
        ItemRepository itemRepository = new ItemRepositoryInMemory();
        CouponRepository couponRepository = new CouponRepositoryInMemory();
        OrderRepository orderRepository = new OrderRepositoryInMemory();
        ZipCodeCalculatorApi zipCodeCalculatorApi = new ZipCodeCalculatorApiApiMemory();
        PlaceOrderCU placeOrderCU = new PlaceOrderCU(itemRepository, couponRepository, orderRepository, zipCodeCalculatorApi);
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO(cpf.getDocument(), items, coupon.getCode(), zipCode, "20210101000001");
        PlaceOrderCheckoutDTO placeOrderCheckoutDTO = placeOrderCU.execute(placeOrderDTO);
        assertEquals(placeOrderCheckoutDTO.getFreight(), new BigDecimal("310.00").setScale(1));
    }
}
