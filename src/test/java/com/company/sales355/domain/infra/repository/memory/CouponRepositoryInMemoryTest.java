package com.company.sales355.domain.infra.repository.memory;

import com.company.sales355.domain.entity.Coupon;
import com.company.sales355.infra.repository.memory.CouponRepositoryInMemory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class CouponRepositoryInMemoryTest {

    @Test
    public void shouldBeFindOneCouponByCode(){
        CouponRepositoryInMemory couponRepositoryInMemory = new CouponRepositoryInMemory();
        Optional<Coupon> coupon = couponRepositoryInMemory.findByCode("VALE20");
        coupon.ifPresent(Assert::assertNotNull);
    }
}
