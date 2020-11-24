package com.validator.cnpj;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cnpj")
public interface ValidadorCNPJRest {

    @RequestMapping("/{cnpj}")
    public Boolean isValid(@PathVariable String cnpj);

}
