package org.telaCadastro.controller;

import javafx.scene.control.Alert;
import model.Cliente;
import javafx.scene.control.TextField;

public class ClienteController {

    private Cliente cliente;


    public void salvarCliente(String txtNome) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sucesso");
        alerta.setHeaderText(null);
        alerta.setContentText("Cadastro de " + txtNome + " realizado com sucesso!");
        alerta.showAndWait();
    }
}
