package com.company.sales355.entity;

import java.math.BigDecimal;

public class Item {

    private String code;
    private String description;
    private BigDecimal price;
    private float width;
    private float height;
    private float length;
    private float weight;

    public Item(String code, String description, BigDecimal price, int width, int height, int length, int weight) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public double getVolume() {
        return this.width/100 * this.height/100 * this.length/100;
    }

    public double getDensity() {
        return this.weight / this.getVolume();
    }
}
