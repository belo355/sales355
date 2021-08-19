package com.company.sales355.application;

import java.math.BigDecimal;

public class PlaceOrderOutputDTO {

    private BigDecimal total;
    private BigDecimal freight;

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
}
