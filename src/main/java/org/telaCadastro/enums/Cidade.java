package org.telaCadastro.enums;

public enum Cidade {
    CAJAMAR,
    BARUERI,
    SANTANA_DE_PARNAIBA("Santana de Parnaíba");

    private final String descricao;

    Cidade(String s) {
        this.descricao = s;
    }

    Cidade() {
        String texto = name().replace("_", " ").toLowerCase();

        this.descricao =
                Character.toUpperCase(texto.charAt(0))
                        + texto.substring(1);
    }

    public String getDescricao(){
        return descricao;
    }
}