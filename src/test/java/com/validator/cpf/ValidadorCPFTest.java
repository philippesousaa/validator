package com.validator.cpf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorCPFTest {

    @Test
    public void ValidarCPFTrue() {
        String cpfValid = "193.917.170-98";
        Boolean valid = ValidadorCPF.isCpfValid(cpfValid);
        Assertions.assertEquals(valid, Boolean.TRUE);
    }

    @Test
    public void ValidarCPFFalse() {
        String cpfValid = "215.761.960-50";
        Boolean valid = ValidadorCPF.isCpfValid(cpfValid);
        Assertions.assertEquals(valid, Boolean.FALSE);
    }

    @Test
    public void ValidarCPF1numeroRepetido() {
        String cpfValid = "11111111111";
        Boolean valid = ValidadorCPF.isCpfValid(cpfValid);
        Assertions.assertEquals(valid, Boolean.FALSE);
    }

    @Test
    public void ValidarCPFTrueDigito0() {
        String cpfValid = "166.633.670-05";
        Boolean valid = ValidadorCPF.isCpfValid(cpfValid);
        Assertions.assertEquals(valid, Boolean.TRUE);
    }
}
