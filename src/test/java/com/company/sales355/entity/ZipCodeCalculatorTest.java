package com.company.sales355.entity;

import com.company.sales355.userCase.ZipCodeCalculatorApiMemory;
import org.junit.Assert;
import org.junit.Test;

public class ZipCodeCalculatorTest {

    @Test
    public void shouldBeCalculatorDistanceBetweenZipcods(){
        ZipCodeCalculator zipCodeCalculator = new ZipCodeCalculatorApiMemory();
        int distance = zipCodeCalculator.calculate("11.111-11", "22.222-22");
        Assert.assertEquals(1000, distance);
    }
}
