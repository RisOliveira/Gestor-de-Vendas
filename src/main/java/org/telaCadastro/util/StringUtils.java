package org.telaCadastro.util;

import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class StringUtils {

    public static void aplicarCPF(TextField campo) {

        final boolean[] formatando = {false};

        campo.textProperty().addListener((observable, antigo, novo) -> {

            if (formatando[0]) {
                return;
            }

            formatando[0] = true;

            int cursor = campo.getCaretPosition();

            int numerosAntesDoCursor = 0;

            for (int i = 0; i < Math.min(cursor, novo.length()); i++) {

                if (Character.isDigit(novo.charAt(i))) {
                    numerosAntesDoCursor++;
                }
            }

            String numeros = novo.replaceAll("\\D", "");

            if (numeros.length() > 11) {
                numeros = numeros.substring(0, 11);
            }

            StringBuilder formatado = new StringBuilder();

            if (numeros.length() > 0) {
                formatado.append(numeros, 0,
                        Math.min(3, numeros.length()));
            }

            if (numeros.length() > 3) {
                formatado.append(".");
                formatado.append(numeros, 3,
                        Math.min(6, numeros.length()));
            }

            if (numeros.length() > 6) {
                formatado.append(".");
                formatado.append(numeros, 6,
                        Math.min(9, numeros.length()));
            }

            if (numeros.length() > 9) {
                formatado.append("-");
                formatado.append(numeros, 9,
                        numeros.length());
            }

            campo.setText(formatado.toString());

            int novaPosicao = calcularPosicaoCursor(
                    formatado.toString(),
                    numerosAntesDoCursor
            );

            campo.positionCaret(novaPosicao);

            formatando[0] = false;
        });
    }


    public static void aplicarData(TextField campo) {

        final boolean[] formatando = {false};

        campo.textProperty().addListener((observable, antigo, novo) -> {

            if (formatando[0]) {
                return;
            }

            formatando[0] = true;

            int cursor = campo.getCaretPosition();

            int numerosAntesDoCursor = 0;

            for (int i = 0; i < Math.min(cursor, novo.length()); i++) {

                if (Character.isDigit(novo.charAt(i))) {
                    numerosAntesDoCursor++;
                }
            }

            String numeros = novo.replaceAll("\\D", "");

            if (numeros.length() > 8) {
                numeros = numeros.substring(0, 8);
            }

            StringBuilder formatado = new StringBuilder();

            if (numeros.length() > 0) {
                formatado.append(numeros, 0,
                        Math.min(2, numeros.length()));
            }

            if (numeros.length() > 2) {
                formatado.append("/");
                formatado.append(numeros, 2,
                        Math.min(4, numeros.length()));
            }

            if (numeros.length() > 4) {
                formatado.append("/");
                formatado.append(numeros, 4,
                        numeros.length());
            }

            campo.setText(formatado.toString());

            int novaPosicao = calcularPosicaoCursor(
                    formatado.toString(),
                    numerosAntesDoCursor
            );

            campo.positionCaret(novaPosicao);

            formatando[0] = false;
        });
    }


    public static void aplicarTelefone(TextField campo) {

        final boolean[] formatando = {false};

        campo.textProperty().addListener((observable, antigo, novo) -> {

            if (formatando[0]) {
                return;
            }

            formatando[0] = true;

            int cursor = campo.getCaretPosition();

            int numerosAntesDoCursor = 0;

            for (int i = 0; i < Math.min(cursor, novo.length()); i++) {

                if (Character.isDigit(novo.charAt(i))) {
                    numerosAntesDoCursor++;
                }
            }

            String numeros = novo.replaceAll("\\D", "");

            if (numeros.length() > 11) {
                numeros = numeros.substring(0, 11);
            }

            StringBuilder formatado = new StringBuilder();

            if (numeros.length() > 0) {
                formatado.append("(");
                formatado.append(numeros, 0,
                        Math.min(2, numeros.length()));
            }

            if (numeros.length() > 2) {
                formatado.append(") ");
                formatado.append(numeros, 2,
                        Math.min(7, numeros.length()));
            }

            if (numeros.length() > 7) {
                formatado.append("-");
                formatado.append(numeros, 7,
                        numeros.length());
            }

            campo.setText(formatado.toString());

            int novaPosicao = calcularPosicaoCursor(
                    formatado.toString(),
                    numerosAntesDoCursor
            );

            campo.positionCaret(novaPosicao);

            formatando[0] = false;
        });
    }


    private static int calcularPosicaoCursor(
            String texto,
            int quantidadeNumeros) {

        if (quantidadeNumeros <= 0) {
            return 0;
        }

        int numerosContados = 0;

        for (int i = 0; i < texto.length(); i++) {

            if (Character.isDigit(texto.charAt(i))) {
                numerosContados++;

                if (numerosContados == quantidadeNumeros) {
                    return i + 1;
                }
            }
        }

        return texto.length();
    }


    public static boolean emailValido(String email) {

        if (email == null || email.isBlank()) {
            return false;
        }

        String regex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(regex, email);
    }

    public static String vazioParaNulo(String valor) {

        if (valor == null || valor.isBlank()) {
            return null;
        }

        return valor.trim();
    }

    public static LocalDate vazioParaNulo(LocalDate valor) {

        if (valor == null) {
            return null;
        }

        return valor;
    }
}
