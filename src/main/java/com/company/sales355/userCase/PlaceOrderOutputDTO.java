package com.company.sales355.userCase;

import java.math.BigDecimal;

public class PlaceOrderOutputDTO {

    private BigDecimal total;

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return this.total; 
    }
}
