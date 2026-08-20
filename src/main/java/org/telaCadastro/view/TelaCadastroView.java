package org.telaCadastro.view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.telaCadastro.controller.ClienteController;

public class TelaCadastroView {

    private final ClienteController controller;
    private Scene scene;

    public TelaCadastroView(ClienteController controller){

        this.controller = controller;

        Label lblNome = new Label("Nome");
        TextField txtNome = new TextField();
        Button btnSalvar = new Button("Salvar");

        btnSalvar.setOnAction(e ->

                controller.salvarCliente(txtNome.getText())

        );

        VBox root = new VBox(lblNome, txtNome, btnSalvar);

        scene = new Scene(root,500,400);

    }

    public Scene getScene() {
        return scene;
    }

}
