package com.company.sales355.userCase;

import com.company.sales355.entity.Coupon;
import com.company.sales355.entity.CouponRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CouponRepositoryInMemory implements CouponRepository {
    List<Coupon> coupons = new ArrayList<>();

    public CouponRepositoryInMemory(){
        coupons.add(new Coupon("VALE20", 20, LocalDate.now()));
        coupons.add(new Coupon("VALE20_EXPIRED", 20, LocalDate.of(2020, 1, 1)));
    }
    @Override
    public Optional<Coupon> findByCode(String code) {
        return this.coupons.stream().filter(c -> c.getCode().equals(code)).findFirst();
    }
}
