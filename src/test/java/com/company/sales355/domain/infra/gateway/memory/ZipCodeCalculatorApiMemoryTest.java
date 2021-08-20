package com.company.sales355.domain.infra.gateway.memory;

import com.company.sales355.infra.gateway.memory.ZipCodeCalculatorApiApiMemory;
import org.junit.Test;

public class ZipCodeCalculatorApiMemoryTest {

    @Test
    public void shouldBeCalculatorBetweenThowZipCode() {
        String zipcodeOrig = "11.11-111";
        String zipcodeDestino = "22.22-222";
        ZipCodeCalculatorApiApiMemory zipCodeCalculatorApiApiMemory = new ZipCodeCalculatorApiApiMemory();
        zipCodeCalculatorApiApiMemory.calculate(zipcodeOrig, zipcodeDestino);
    }
}
