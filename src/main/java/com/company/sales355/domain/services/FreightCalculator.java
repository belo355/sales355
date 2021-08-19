package com.company.sales355.domain.services;

import com.company.sales355.domain.entity.Item;

public class FreightCalculator {
    public double calculate(int distance, Item item){
        return distance * item.getVolume() * (item.getDensity()/100);
    }
}
