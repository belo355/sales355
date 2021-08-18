package com.company.sales355.userCase;

import com.company.sales355.entity.ZipCodeCalculator;

public class ZipCodeCalculatorApiMemory implements ZipCodeCalculator {

    @Override
    public int calculate(String zipcodeOrig, String zipCodeDest) {
        return 1000;
    }
}
