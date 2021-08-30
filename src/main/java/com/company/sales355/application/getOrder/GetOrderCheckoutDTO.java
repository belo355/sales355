package com.company.sales355.application.getOrder;

import java.math.BigDecimal;
import java.util.List;

public class GetOrderCheckoutDTO {

    private String code;
    private BigDecimal freight;
    private BigDecimal total;
    private List<OrderInvoicedItemDTO> itemList;

    public GetOrderCheckoutDTO(String code, BigDecimal freight, BigDecimal total, List<OrderInvoicedItemDTO> itemList){
        this.code = code;
        this.freight = freight;
        this.total = total;
        this.itemList = itemList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
