package com.company.sales355.application.placeOrder;

import com.company.sales355.domain.entity.OrderItem;

import java.util.List;

public class PlaceOrderDTO {

    private String cpf;
    private List<OrderItem> items;
    private String coupon;
    private String code;

    public String getZipCode() {
        return zipCode;
    }

    public PlaceOrderDTO(String cpf, List<OrderItem> items, String coupon, String zipCode) {
        this.cpf = cpf;
        this.items = items;
        this.coupon = coupon;
        this.zipCode = zipCode;
        this.code = "";
    }

    public PlaceOrderDTO(String cpf, List<OrderItem> items, String coupon, String zipCode, String code) {
        this.cpf = cpf;
        this.items = items;
        this.coupon = coupon;
        this.zipCode = zipCode;
        this.code = code;
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

    public String getCode() {
        return code;
    }
}
