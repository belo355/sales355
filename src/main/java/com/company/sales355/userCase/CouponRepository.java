package com.company.sales355.userCase;

import com.company.sales355.entity.Coupon;

import java.util.Optional;

public interface CouponRepository {
    Optional<Coupon> findById(String id);
}
