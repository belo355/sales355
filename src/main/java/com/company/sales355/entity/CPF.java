package com.company.sales355.entity;

import java.util.InputMismatchException;

public class CPF {
    private String cpf;

    public CPF(String cpf) {
        if(!isValid(cpf)){
            throw new Error("Invalid CPF");
        }
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    private boolean isValid(String document){
        if (document.equals("00000000000") ||
                document.equals("11111111111") ||
                document.equals("22222222222") || document.equals("33333333333") ||
                document.equals("44444444444") || document.equals("55555555555") ||
                document.equals("66666666666") || document.equals("77777777777") ||
                document.equals("88888888888") || document.equals("99999999999") ||
                (document.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (document.toString().charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = document.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == document.charAt(9)) && (dig11 == document.charAt(10)))
                return (true);
            else return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
