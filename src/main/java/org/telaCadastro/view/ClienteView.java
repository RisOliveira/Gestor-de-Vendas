package org.telaCadastro.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.telaCadastro.controller.ClienteController;
import org.telaCadastro.model.Cliente;

import javax.swing.*;
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

        // ==========================================
        //    PAINEL DE CLIENTES
        // ==========================================

        VBox painelClientes = new VBox(2);

        HBox cabecalho = new HBox(10);
        cabecalho.setAlignment(Pos.TOP_LEFT);
        cabecalho.setSpacing(10);
        cabecalho.getStyleClass().add("cabecalho");


        Label cbId = new Label("Id     ");
        Label cbNome = new Label("Nome");
        Label cbCpf = new Label("CPF");
        Label cbTelefone = new  Label("Telefone");
        Label cbRua = new  Label("Rua");
        Label cbNumero = new  Label("Numero");

        cbId.setPrefWidth(85);
        cbId.setAlignment(Pos.TOP_RIGHT);
        cbNome.setPrefWidth(225);
        cbCpf.setPrefWidth(150);
        cbTelefone.setPrefWidth(150);
        cbRua.setPrefWidth(250);
        cbNumero.setPrefWidth(60);

        cabecalho.getChildren().addAll(cbId, cbNome, cbCpf, cbTelefone, cbRua, cbNumero);

        List<Cliente> clientes;

        try {
            clientes = controller.listar();
        } catch (Exception e) {

            clientes = new ArrayList<>();

            Cliente cliente = new Cliente();
            cliente.setId(1);
            cliente.setNome("João da Silva");
            cliente.setCpf("123.456.789-00");
            cliente.setTelefone("(11) 99999-9999");
            cliente.setRua("Rua Teste");
            cliente.setNumero("123");

            Cliente cliente2 = new Cliente();
            cliente2.setId(2);
            cliente2.setNome("Maria Oliveira");
            cliente2.setCpf("987.654.321-00");
            cliente2.setTelefone("(11) 98888-8888");
            cliente2.setRua("Rua Central");
            cliente2.setNumero("456");

            Cliente cliente3 = new Cliente();
            cliente3.setId(3);
            cliente3.setNome("Carlos Souza");
            cliente3.setCpf("111.222.333-44");
            cliente3.setTelefone("(11) 97777-7777");
            cliente3.setRua("Rua Comercial");
            cliente3.setNumero("789");

            clientes.add(cliente);
            clientes.add(cliente2);
            clientes.add(cliente3);
        }

        for(Cliente cliente : clientes){
            HBox card = new HBox(20);

            if(painelClientes.getChildren().size()%2 != 0){
                card.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            }

            CheckBox checkBox = new CheckBox();
            Label lblId = new Label(String.valueOf(cliente.getId()));
            Label lblNome = new Label(cliente.getNome());
            Label lblCpf= new Label(cliente.getCpf());
            Label lblTelefone = new Label(cliente.getTelefone());
            Label lblRua = new Label(cliente.getRua());
            Label lblNumero = new Label(cliente.getNumero());

            checkBox.setPadding(new Insets(5,5,5,5));
            lblId.setPadding(new Insets(5,5,5,5));
            lblNome.setPrefWidth(200);
            lblNome.setPadding(new Insets(5,5,5,5));
            lblCpf.setPrefWidth(150);
            lblCpf.setPadding(new Insets(5,5,5,5));
            lblTelefone.setPrefWidth(150);
            lblTelefone.setPadding(new Insets(5,5,5,5));
            lblRua.setPrefWidth(250);
            lblRua.setPadding(new Insets(5,5,5,5));
            lblNumero.setPrefWidth(80);
            lblNumero.setPadding(new Insets(5,5,5,5));

            card.getChildren().addAll(
                    checkBox,
                    lblId,
                    lblNome,
                    lblCpf,
                    lblTelefone,
                    lblRua,
                    lblNumero
            );

            card.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2){
                    Stage stage = new Stage();
                    stage.setScene(cadastroView.getScene());
                    stage.show();
                }
            });
            painelClientes.getChildren().add(card);
        }

        ScrollPane scroll = new ScrollPane(painelClientes);
        scroll.setFitToWidth(true);
        scroll.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));


        // =========================
        // CONTAINER DA TELA
        // =========================

        VBox root = new VBox(10);

        root.setPadding(new Insets(30));
        root.getChildren().addAll(
                lblTitulo, botoes,cabecalho, scroll
        );




        // =========================
        // SCENE
        // =========================

        scene = new Scene(root, 1100, 850);

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
