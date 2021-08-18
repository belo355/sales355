package com.company.sales355.userCase;

import com.company.sales355.entity.OrderItem;

import java.util.List;

public class PlaceOrderDTO {

    private String cpf;
    private List<OrderItem> items;
    private String coupon;

    public String getZipCode() {
        return zipCode;
    }

    public PlaceOrderDTO(String cpf, List<OrderItem> items, String coupon, String zipCode) {
        this.cpf = cpf;
        this.items = items;
        this.coupon = coupon;
        this.zipCode = zipCode;
    }

    public String getCpf() {
        return cpf;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getCoupon() {
        return coupon;
    }

    private String zipCode;

}
