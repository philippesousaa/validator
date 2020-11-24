package com.validator.cnpj;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidarCNPJRestImpl implements ValidadorCNPJRest {

    @Override
    public Boolean isValid(@PathVariable String cnpj) {
        return ValidatorCNPJ.isCNPJValid(cnpj);
    }

}
