package com.validator.cpf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpf")
public interface ValidadorCPFRest {

    @GetMapping("/{cpf}")
    public Boolean validarCpf(@PathVariable String cpf);
}
