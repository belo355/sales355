package com.company.sales355.userCase;

import com.company.sales355.entity.Cpf;
import com.company.sales355.entity.Coupon;
import com.company.sales355.entity.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaceOrderTest {

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
        PlaceOrder placeOrder = new PlaceOrder(itemRepository, couponRepository, orderRepository );
        PlaceOrderOutputDTO placeOrderOutputDTO = placeOrder.execute(placeOrderDTO);
        assertEquals(placeOrderOutputDTO.getTotal(), new BigDecimal("5672.0"));
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
        PlaceOrder placeOrder = new PlaceOrder(itemRepository, couponRepository, orderRepository );
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO(cpf.getDocument(), items, coupon.getCode(),zipCode);
        PlaceOrderOutputDTO placeOrderOutputDTO = placeOrder.execute(placeOrderDTO);
        assertEquals(placeOrderOutputDTO.getTotal(), new BigDecimal("7400.0"));
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
        PlaceOrder placeOrder = new PlaceOrder(itemRepository, couponRepository, orderRepository );
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO(cpf.getDocument(), items, coupon.getCode(), zipCode);
        PlaceOrderOutputDTO placeOrderOutputDTO = placeOrder.execute(placeOrderDTO);
        assertEquals(placeOrderOutputDTO.getFreight(), new BigDecimal("310.0"));
    }
}
