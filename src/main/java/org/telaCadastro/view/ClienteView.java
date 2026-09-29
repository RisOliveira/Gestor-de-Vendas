package org.telaCadastro.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.telaCadastro.controller.ClienteController;
import org.telaCadastro.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteView {


    private final ClienteController controller;
    private final TelaCadastroView cadastroView;
    private Scene scene;


    public ClienteView(ClienteController controller) {
        this.controller = controller;
        this.cadastroView = new TelaCadastroView(controller);


        // =========================
        // TÍTULO
        // =========================

        Label lblTitulo = new Label("Clientes");
        lblTitulo.getStyleClass().add("title");

        lblTitulo.setMaxWidth(Double.MAX_VALUE);
        lblTitulo.setAlignment(Pos.CENTER);

        // ================================
        // BOTÕES
        // ================================

        Button btnCadastrar = new Button("Novo");
        btnCadastrar.getStyleClass().add("btnAdd");
        btnCadastrar.setOnAction(e -> {
            Stage stage = new Stage();

            stage.setScene(cadastroView.getScene());
            stage.setTitle("Cadastro");

            stage.show();
        });

        Button btnEditar = new Button("Editar");
        btnEditar.getStyleClass().add("botao-principal");
        btnEditar.setOnAction(e -> {
            Stage stage = new Stage();

            stage.setScene(cadastroView.getScene());
            stage.setTitle("Cadastro");

            stage.show();
        });

        Button btnExcluir = new Button("Excluir");
        btnExcluir.getStyleClass().add("botao-principal");

        HBox botoes = new HBox(10);
        botoes.setAlignment(Pos.TOP_LEFT);
        botoes.setSpacing(10);
        botoes.setPadding(new Insets(10));
        botoes.setStyle("-fx-padding: 10;");
        botoes.getChildren().addAll(btnCadastrar, btnEditar, btnExcluir);

        VBox painelClientes = new VBox(10);

        List<Cliente> clientes = controller.listar();

        for(Cliente cliente : clientes){
            HBox card = new HBox(5);

            card.getChildren().addAll(
                    new Label("cliente.getNome()"),
                    new Label("cliente.getCpf()"),
                    new Label("cliente.getTelefone()"),
                    new Label("cliente.getRua()"),
                    new Label("cliente.getNumero()")
            );

            painelClientes.getChildren().add(card);
        }

        ScrollPane scroll = new ScrollPane(painelClientes);
        scroll.setFitToWidth(true);


        // =========================
        // CONTAINER DA TELA
        // =========================

        VBox root = new VBox(10);

        root.setPadding(new Insets(30));
        root.getChildren().addAll(
                lblTitulo, botoes, scroll
        );




        // =========================
        // SCENE
        // =========================

        scene = new Scene(root, 800, 600);

        scene.getStylesheets().add(
                getClass()
                        .getResource("/css/global.css")
                        .toExternalForm()
        );

        scene.getStylesheets().add(
                getClass()
                        .getResource("/css/componente.css")
                        .toExternalForm()
        );

        scene.getStylesheets().add(
                getClass()
                        .getResource("/css/view.css")
                        .toExternalForm()
        );

    }

    public Scene getScene() {
        return scene;
    }
}
