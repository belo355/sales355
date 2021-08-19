package com.company.sales355.domain.entity;

import java.math.BigDecimal;

public class Item {

    private String id;
    private String description;
    private BigDecimal price;
    private float width;
    private float height;
    private float length;
    private float weight;

    public Item(String id, String description, BigDecimal price, int width, int height, int length, int weight) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getLength() {
        return length;
    }

    public float getWeight() {
        return weight;
    }
}
