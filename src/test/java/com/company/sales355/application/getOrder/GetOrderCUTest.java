package com.company.sales355.application.getOrder;

import com.company.sales355.application.getOrder.GetOrderCheckoutDTO;
import com.company.sales355.application.placeOrder.PlaceOrderCU;
import com.company.sales355.application.placeOrder.PlaceOrderCheckoutDTO;
import com.company.sales355.application.placeOrder.PlaceOrderDTO;
import com.company.sales355.application.getOrder.GetOrderCU;
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

public class GetOrderCUTest {

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

        GetOrderCU getOrderCU = new GetOrderCU(itemRepository, couponRepository, orderRepository);
        GetOrderCheckoutDTO getOrderCheckoutDTO = getOrderCU.execute(placeOrderCheckoutDTO.getCode());
        assertEquals(getOrderCheckoutDTO.getCode(), placeOrderCheckoutDTO.getCode());
    }

}
