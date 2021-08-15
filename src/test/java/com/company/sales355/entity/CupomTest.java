package com.company.sales355.entity;

import org.junit.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CupomTest {

    @Test
    public void shouldBeVerifyCouponExpired(){
        Cupom cupom = new Cupom("VALE20", 20, LocalDate.of(2020, 1, 1));
        assertTrue(cupom.isExpired());
    }
}