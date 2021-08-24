package com.company.sales355.domain.service;

import com.company.sales355.domain.entity.Item;
import com.company.sales355.domain.services.FreightCalculator;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreightCalculatorTest {

    @Test
    public void shouldBeCalculateFreightProductGuitarra(){
        Item item = new Item("1", "Guitarra", new BigDecimal("1000"), 100, 50, 15, 3);
        int distance = 1000;
        FreightCalculator freightCalculator = new FreightCalculator();
        double price = freightCalculator.calculate(distance, item);
        BigDecimal priceFreight = new BigDecimal(price);
        assertEquals(new BigDecimal("30"), priceFreight);
    }

    @Test
    public void shouldBeCalculateFreightProductAmplificador() {
        Item item = new Item("2", "Amplificador", new BigDecimal("5000"), 50, 50, 50, 22);
        int distance = 1000;
        FreightCalculator freightCalculator = new FreightCalculator();
        BigDecimal price = BigDecimal.valueOf(freightCalculator.calculate(distance, item)).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal priceExpected = new BigDecimal("220.00");
        assertEquals(priceExpected, price);
    }
}
    