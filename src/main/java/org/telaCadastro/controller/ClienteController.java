package org.telaCadastro.controller;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.telaCadastro.model.Cliente;

import java.time.LocalDate;

public class ClienteController {

    private Cliente cliente = new Cliente();

    public void okCliente(String nome,
                          String cpf,
                          LocalDate dataNasc,
                          String telefone,
                          String email,
                          String rua,
                          String numero,
                          String compl,
                          String bairro,
                          String cidade,
                          String estado,
                          String pais, Event event) {

        try {

            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setDataNasc(dataNasc);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setRua(rua);
            cliente.setNumero(numero);
            cliente.setCompl(compl);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);
            cliente.setPais(pais.equals("Brasileiro"));



            // MENSAGEM DE SUCESSO
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Sucesso");
            alerta.setHeaderText(null);
            alerta.setContentText("Cadastro de " + nome + " realizado com sucesso!");
            alerta.showAndWait();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    public void salvarCliente( String nome,
                               String cpf,
                               LocalDate dataNasc,
                               String telefone,
                               String email,
                               String rua,
                               String numero,
                               String compl,
                               String bairro,
                               String cidade,
                               String estado,
                               String pais
    ) {

        try {

            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setDataNasc(dataNasc);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setRua(rua);
            cliente.setNumero(numero);
            cliente.setCompl(compl);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);
            cliente.setPais(pais.equals("Brasileiro"));



            // MENSAGEM DE SUCESSO
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Sucesso");
            alerta.setHeaderText(null);
            alerta.setContentText("Cadastro de " + nome + " realizado com sucesso!");
            alerta.showAndWait();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void fechar(Event event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
