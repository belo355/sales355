package com.company.sales355.infra.gateway.memory;

import com.company.sales355.domain.gateway.memory.ZipCodeCalculatorApi;

public class ZipCodeCalculatorApiApiMemory implements ZipCodeCalculatorApi {

    @Override
    public int calculate(String zipcodeOrig, String zipCodeDest) {
        return 1000;
    }
}
