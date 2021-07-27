package com.company.sales355.domain;

import java.util.List;

public class Bag {

    private List<Producto> productoList;

    public Bag(){}
    public Bag(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public void addProducto(Producto producto) {
        this.productoList.add(producto);
    }

    public List<Producto> getProductoList() {
        return productoList;
    }
}
