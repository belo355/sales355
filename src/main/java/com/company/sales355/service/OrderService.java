package com.company.sales355.service;

import com.company.sales355.domain.Bag;
import com.company.sales355.domain.DocumentIdentification;
import com.company.sales355.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    private DocumentationIdentificationService documentationIdentificationService;

    public boolean ValidDocumentIdentificationIntoOrder(Order order) {
        return documentationIdentificationService.valid(order.getDocumentIdentification());
    }

    public Order createOrder(DocumentIdentification documentIdentification, Bag bag){
        return new Order(documentIdentification, bag);
    }
}
