package com.company.sales355.entity;

import com.company.sales355.entity.Coupon;

import java.util.Optional;

public interface CouponRepository {
    Optional<Coupon> findByCode(String code);
}