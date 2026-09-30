package org.telaCadastro.controller;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.telaCadastro.model.Cliente;
import org.telaCadastro.service.ClienteService;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class ClienteController {

    private Cliente cliente = new Cliente();
    private ClienteService clienteService = new ClienteService();

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
                          String pais,
                          Event event) {

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
            cliente.setPais("Brasileiro".equals(pais));

            List<String> erros = clienteService.salvar(cliente);

            if (erros.isEmpty()) {

                Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
                sucesso.setTitle("Sucesso");
                sucesso.setHeaderText(null);
                sucesso.setContentText(
                        "Cadastro de " + cliente.getNome() + " realizado com sucesso!"
                );
                sucesso.showAndWait();

                fechar(event);

            } else {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Atenção");
                alerta.setHeaderText("Não foi possível cadastrar o cliente");
                alerta.setContentText(String.join("\n", erros));
                alerta.showAndWait();
            }

        } catch (Exception e) {

            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setHeaderText("Erro ao cadastrar cliente");
            erro.setContentText(e.getMessage());
            erro.showAndWait();
        }
    }


    public void salvarCliente(String nome,
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
                              String pais) {

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
            cliente.setPais("Brasileiro".equals(pais));

            List<String> erros = clienteService.salvar(cliente);

            if (erros.isEmpty()) {

                Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
                sucesso.setTitle("Sucesso");
                sucesso.setHeaderText(cliente.getNome() + " cadastrado com sucesso!");
                sucesso.showAndWait();

            } else {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Atenção");
                alerta.setHeaderText("Não foi possível cadastrar o cliente");
                alerta.setContentText(String.join("\n", erros));
                alerta.showAndWait();
            }

        } catch (Exception e) {

            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setHeaderText("Erro ao cadastrar cliente");
            erro.setContentText(e.getMessage());
            erro.showAndWait();
        }
    }


    public void editarCliente(Long id,
                              String nome,
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
                              String pais) {

        try {

            cliente.setId(id);
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
            cliente.setPais("Brasileiro".equals(pais));

            List<String> erros = clienteService.editar(cliente);

            if (erros.isEmpty()) {

                Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
                sucesso.setTitle("Sucesso");
                sucesso.setHeaderText("Cliente atualizado com sucesso!");
                sucesso.setContentText(cliente.getNome());
                sucesso.showAndWait();

            } else {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Atenção");
                alerta.setHeaderText("Não foi possível atualizar o cliente");
                alerta.setContentText(String.join("\n", erros));
                alerta.showAndWait();
            }

        } catch (Exception e) {

            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setHeaderText("Erro ao atualizar cliente");
            erro.setContentText(e.getMessage());
            erro.showAndWait();
        }
    }


    public void fechar(Event event) {

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.close();
    }

    public List<Cliente> listar(){
        return clienteService.listar();
    }
}


