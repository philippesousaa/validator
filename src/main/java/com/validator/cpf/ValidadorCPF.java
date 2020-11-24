package com.validator.cpf;

/***
 * 
 * @author Philippe Sousa
 *
 */
public class ValidadorCPF {

    /***
     * 
     * @param String com o cpf, podendo conter ou não '.' e '-'
     * 
     * @return Boolean trazendo true para cpf válido e False para cpf inválido
     */

    public static boolean isCpfValid(String cpf) {
        cpf = tirarPontos(cpf);

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11)) {
            return Boolean.FALSE;
        }

        // 48 é a posição do 0 em ASCII
        final int posicaoZero = 48;

        int peso, soma, resultado, primeiroDigito, segundoDigito;
        peso = 10;
        soma = 0;

        // calculo primeiro digito
        for (int i = 0; i < 9; i++) {
            soma += ((int) cpf.charAt(i) - posicaoZero) * peso;
            peso -= 1;
        }

        resultado = 11 - (soma % 11);
        if (resultado == 10 || resultado == 11) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = resultado;
        }

        peso = 11;
        soma = 0;

        // calculando segundo digito;
        for (int i = 0; i < 10; i++) {
            soma += ((int) cpf.charAt(i) - posicaoZero) * peso;
            peso -= 1;
        }

        resultado = 11 - (soma % 11);

        if (resultado == 10 || resultado == 11) {
            segundoDigito = 0;
        } else {
            segundoDigito = (char) resultado;
        }

        // verificar o digitos calculados conferem com os digitos
        if (primeiroDigito == ((int) cpf.charAt(9) - posicaoZero) && segundoDigito == ((int) cpf.charAt(10) - posicaoZero)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private static String tirarPontos(String string) {
        return string.replace(".", "").replace("-", "");
    }
}
