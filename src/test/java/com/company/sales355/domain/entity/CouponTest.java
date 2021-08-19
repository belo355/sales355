package com.company.sales355.domain.entity;

import org.junit.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CouponTest {

    @Test
    public void shouldBeVerifyCouponExpired(){
        Coupon coupon = new Coupon("VALE20", 20, LocalDate.of(2020, 1, 1));
        assertTrue(coupon.isExpired());
    }
}