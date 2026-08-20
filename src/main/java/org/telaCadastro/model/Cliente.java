package model;

import enums.Cidade;

import java.util.Date;

public class Cliente {

    private long id;
    private String name;
    private String CPF;
    private Date dataNasc;
    private String endereco;
    private String numero;
    private String bairro;
    private String compl;
    private Cidade cidade;

    public Cliente(long id, String name, String CPF, Date dataNasc, String endereco, String numero, String bairro, String compl, Cidade cidade) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.compl = compl;
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
