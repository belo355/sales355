package com.company.sales355.domain.entity;

import java.util.InputMismatchException;

public class Cpf {
    private final String document;

    public Cpf(String cpf) {
        if(!isValid(cpf)){
            throw new Error("Invalid CPF");
        }
        this.document = cpf;
    }

    public String getDocument() {
        return this.document;
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

        char dig10;
        char dig11;

        int sm;
        int i;
        int r;
        int num;
        int peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = document.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48);

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

            return (dig10 == document.charAt(9)) && (dig11 == document.charAt(10));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
