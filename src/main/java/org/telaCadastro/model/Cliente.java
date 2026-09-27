package org.telaCadastro.model;

import java.time.LocalDate;

public class Cliente {

    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataNasc;
    private String rua;
    private String numero;
    private String compl;
    private String bairro;
    private String cidade;
    private String estado;
    private Boolean Pais;

    public Cliente(long id, String nome, String cpf, String telefone, String email, LocalDate dataNasc, String rua, String numero, String compl, String bairro, String cidade, String estado, Boolean pais) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNasc = dataNasc;
        this.rua = rua;
        this.numero = numero;
        this.compl = compl;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        Pais = pais;
    }

    public Cliente() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getPais() {
        return Pais;
    }

    public void setPais(Boolean pais) {
        Pais = pais;
    }
}
