package com.validator.cpf;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/***
 * 
 * @author Philippe
 *
 */

@RestController
public class ValidatorCPFRestImpl implements ValidadorCPFRest {

    @Override
    public Boolean validarCpf(@PathVariable String cpf) {
        return ValidadorCPF.isCpfValid(cpf);
    }

}
