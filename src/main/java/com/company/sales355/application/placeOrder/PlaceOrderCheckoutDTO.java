package com.company.sales355.application.placeOrder;

import java.math.BigDecimal;

public class PlaceOrderCheckoutDTO {

    private BigDecimal total;
    private BigDecimal freight;
    private String code;

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return this.total; 
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
