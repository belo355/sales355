package com.company.sales355.entity;

public class FreightCalculator {

    public static double calculate(int distance, Item item){
        return distance * item.getVolume() * (item.getDensity()/100);
    }
}
