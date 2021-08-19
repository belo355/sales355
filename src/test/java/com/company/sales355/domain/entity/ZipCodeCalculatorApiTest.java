package com.company.sales355.domain.entity;

import com.company.sales355.domain.gateway.memory.ZipCodeCalculatorApi;
import com.company.sales355.infra.gateway.memory.ZipCodeCalculatorApiApiMemory;
import org.junit.Assert;
import org.junit.Test;

public class ZipCodeCalculatorApiTest {

    @Test
    public void shouldBeCalculatorDistanceBetweenZipcods(){
        ZipCodeCalculatorApi zipCodeCalculatorApi = new ZipCodeCalculatorApiApiMemory();
        int distance = zipCodeCalculatorApi.calculate("11.111-11", "22.222-22");
        Assert.assertEquals(1000, distance);
    }
}
