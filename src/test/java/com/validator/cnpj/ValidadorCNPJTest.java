package com.validator.cnpj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorCNPJTest {

    @Test
    public void ValidarCNPJTrue() {
        String cpfValid = "87.296.588/0001-50";
        Boolean valid = ValidatorCNPJ.isCNPJValid(cpfValid);
        Assertions.assertEquals(valid, Boolean.TRUE);
    }

    @Test
    public void ValidarCNPJFalse() {
        String cpfValid = "48.052.577/0001-23";
        Boolean valid = ValidatorCNPJ.isCNPJValid(cpfValid);
        Assertions.assertEquals(valid, Boolean.FALSE);
    }

    @Test
    public void ValidarCNPJNumeroRepetido() {
        String cpfValid = "111111111111111";
        Boolean valid = ValidatorCNPJ.isCNPJValid(cpfValid);
        Assertions.assertEquals(valid, Boolean.FALSE);
    }

    @Test
    public void ValidarCNPJTrueDigito0() {
        String cpfValid = "93.034.050/0001-70";
        Boolean valid = ValidatorCNPJ.isCNPJValid(cpfValid);
        Assertions.assertEquals(valid, Boolean.TRUE);
    }
}
