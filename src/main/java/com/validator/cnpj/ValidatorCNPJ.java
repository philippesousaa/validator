package com.validator.cnpj;

/***
 * 
 * @author Philippe Sousa
 *
 */

public class ValidatorCNPJ {

    /***
     * 
     * @param String com o cpf, podendo conter ou não '.' e '-'
     * 
     * @return Boolean trazendo true para cpf válido e False para cpf inválido
     */

    public static boolean isCNPJValid(String cnpj) {

        cnpj = tirarCaracteresCNPJ(cnpj);

        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
                || cnpj.equals("44444444444444") || cnpj.equals("55555555555555") || cnpj.equals("66666666666666")
                || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")
                || (cnpj.length() != 14)) {
            return Boolean.FALSE;
        }

        // 48 é a posição do 0 em ASCII
        final int posicaoZero = 48;
        int soma, resultado, num, peso, primeiroDigito, segundoDigito;
        soma = 0;
        peso = 2;

        // calculo primeiro digito
        for (int i = 11; i >= 0; i--) {
            soma += ((int) cnpj.charAt(i) - posicaoZero) * peso;
            peso += 1;
            if (peso == 10)
                peso = 2;
        }
        resultado = soma % 11;

        if (resultado == 0 || resultado == 1) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = 11 - resultado;
        }

        soma = 0;
        peso = 2;

        // Calculo segundo digito
        for (int i = 12; i >= 0; i--) {
            soma += (cnpj.charAt(i) - posicaoZero) * peso;
            peso += 1;
            if (peso == 10)
                peso = 2;
        }

        resultado = soma % 11;
        if (resultado == 0 || resultado == 1) {
            segundoDigito = 0;
        } else {
            segundoDigito = 11 - resultado;
        }

        // verificação com os dados
        if (primeiroDigito == (cnpj.charAt(12) - posicaoZero) && segundoDigito == (cnpj.charAt(13) - posicaoZero)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private static String tirarCaracteresCNPJ(String string) {
        return string.replace(".", "").replace("/", "").replace("-", "");
    }
}
