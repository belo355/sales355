package com.company.sales355.entity;

import org.junit.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CupomTest {

    @Test
    public void deveVerificarCupomExpirado(){
        Cupom cupom = new Cupom("VALE20", 20, LocalDate.of(2020, 01, 01));
        assertTrue(cupom.isExpired());
    }
}