package com.company.sales355.entity;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void deveCalcularVolumeItem() {
        Item item = new Item("1", "Guitarra", new BigDecimal("5000"), 50, 50, 50, 22);
        assertEquals(0.125, item.getVolume());
    }

    @Test
    public void deveCalcularADensidadeItem() {
        Item item = new Item("1", "Guitarra", new BigDecimal("5000"), 50, 50, 50, 22);
        assertEquals(176, item.getDensity());
    }
}
