package com.company.sales355.domain.repository;

import com.company.sales355.domain.entity.Coupon;

import java.util.Optional;

public interface CouponRepository {
    Optional<Coupon> findByCode(String code);
}
