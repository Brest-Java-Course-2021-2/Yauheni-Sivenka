package com.epam.brest.calc;

import java.math.BigDecimal;

public class CalcImpl implements Calc{
    @Override
    public BigDecimal handle(BigDecimal weight, BigDecimal pricePerKg, BigDecimal distance, BigDecimal pricePerKm) {
        return weight.multiply(pricePerKg).add(distance.multiply(pricePerKm));
    }
}
