package com.company.sales355.service;

import com.company.sales355.domain.Bag;
import com.company.sales355.domain.Order;
import com.company.sales355.domain.Producto;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public boolean ValidDocumentIdentificationIntoOrder(Order order) {
        DocumentationIdentificationService documentationService = new DocumentationIdentificationService();
        return documentationService.valid(order.getDocumentIdentification());
    }

    public Bag createBagOrder(Producto producto) {
        List<Producto> productoList = new ArrayList<>();
        productoList.add(producto);
        return new Bag(productoList);
    }
}
