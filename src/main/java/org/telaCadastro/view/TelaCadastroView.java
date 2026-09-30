package org.telaCadastro.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.telaCadastro.controller.ClienteController;
import org.telaCadastro.enums.Cidade;
import org.telaCadastro.model.Cliente;
import org.telaCadastro.util.StringUtils;

import java.util.Arrays;

public class TelaCadastroView {

    private final ClienteController controller;
    private Cliente cliente;
    private Scene scene;

    private TextField txtNome;
    private TextField txtCpf;
    private TextField txtTelefone;
    private TextField txtEmail;
    private DatePicker dtNasc;

    private TextField txtRua;
    private TextField txtNumero;
    private TextField txtComp;
    private TextField txtBairro;
    private ComboBox<String> cmbCidade;
    private TextField txtEstado;

    private RadioButton rbBrasileiro;
    private RadioButton rbEstrangeiro;

    public TelaCadastroView(ClienteController controller){
        this(controller, null);
    }

    public TelaCadastroView(ClienteController controller, Cliente cliente) {


        this.controller = controller;
        this.cliente = cliente;

        // =========================
        // GRID PRINCIPAL
        // =========================

        GridPane grid = new GridPane();

        grid.setHgap(15);
        grid.setVgap(12);
        grid.setPadding(new Insets(20));

        // =========================
        // COLUNAS
        // =========================

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        ColumnConstraints col4 = new ColumnConstraints();

        col1.setPercentWidth(12);
        col2.setPercentWidth(38);
        col3.setPercentWidth(12);
        col4.setPercentWidth(38);

        grid.getColumnConstraints().addAll(
                col1, col2, col3, col4
        );

        // =========================
        // TÍTULO
        // =========================

        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.getStyleClass().add("title");

        lblTitulo.setMaxWidth(Double.MAX_VALUE);
        lblTitulo.setAlignment(Pos.CENTER);

        // =========================
        // DADOS PESSOAIS
        // =========================

        Label lblNome = new Label("Nome");
        txtNome = new TextField();
        txtNome.getStyleClass().add("campo");

        Label lblCpf = new Label("CPF");
        txtCpf = new TextField();
        txtCpf.getStyleClass().add("campo");
        StringUtils.aplicarCPF(txtCpf);

        Label lblTelefone = new Label("Telefone");
        txtTelefone = new TextField();
        txtTelefone.getStyleClass().add("campo");
        StringUtils.aplicarTelefone(txtTelefone);



        Label lblEmail = new Label("Email");
        txtEmail = new TextField();
        txtEmail.getStyleClass().add("campo");

        Label lblNasc = new Label("Data Nasc.");
        dtNasc = new DatePicker();
        dtNasc.getStyleClass().add("campo");
        TextField campoData = dtNasc.getEditor();
        StringUtils.aplicarData(campoData);


        // =========================
        // ENDEREÇO
        // =========================

        Label lblRua = new Label("Rua");
        txtRua = new TextField();
        txtRua.getStyleClass().add("campo");

        Label lblNumero = new Label("Número");
        txtNumero = new TextField();
        txtNumero.getStyleClass().add("campo");



        Label lblComp = new Label("Complemento");
        txtComp = new TextField();
        txtComp.getStyleClass().add("campo");

        Label lblBairro = new Label("Bairro");
        txtBairro = new TextField();
        txtBairro.getStyleClass().add("campo");

        Label lblCidade = new Label("Cidade");
        cmbCidade = new ComboBox<>();
        cmbCidade.getStyleClass().add("campo");
        cmbCidade.getItems().addAll(Arrays.stream(Cidade.values()).map(Cidade::getDescricao).toList());

        Label lblEstado = new Label("Estado");
        txtEstado = new TextField();
        txtEstado.getStyleClass().add("campo");

        Label lblPais = new Label("Nacionalidade");

        // =========================
        // RADIOBUTTON
        // =========================

        rbBrasileiro = new RadioButton("Brasileiro");
        rbEstrangeiro = new RadioButton("Estrangeiro");

        ToggleGroup grupoNacionalidade = new ToggleGroup();

        rbBrasileiro.setToggleGroup(grupoNacionalidade);
        rbEstrangeiro.setToggleGroup(grupoNacionalidade);

        // =========================
        // GRUPO NACIONALIDADE
        // =========================

        HBox grupoNaci = new HBox(15);

        grupoNaci.getChildren().addAll(
                rbBrasileiro,
                rbEstrangeiro
        );

        rbBrasileiro.setSelected(true);

        // =========================
        // POSICIONAMENTO
        // =========================

        // Nome
        grid.add(lblNome, 0, 0);
        grid.add(txtNome, 1, 0, 3, 1);

        // Telefone + CPF
        grid.add(lblTelefone, 0, 1);
        grid.add(txtTelefone, 1, 1);

        grid.add(lblCpf, 2, 1);
        grid.add(txtCpf, 3, 1);

        // Email + Nascimento
        grid.add(lblEmail, 0, 2);
        grid.add(txtEmail, 1, 2);

        grid.add(lblNasc, 2, 2);
        grid.add(dtNasc, 3, 2);

        // =========================
        // ENDEREÇO
        // =========================

        // Rua
        grid.add(lblRua, 0, 3);
        grid.add(txtRua, 1, 3, 3, 1);

        // Número + Complemento
        grid.add(lblNumero, 0, 4);
        grid.add(txtNumero, 1, 4);

        grid.add(lblComp, 2, 4);
        grid.add(txtComp, 3, 4);

        // Bairro
        grid.add(lblBairro, 0, 5);
        grid.add(txtBairro, 1, 5, 3, 1);

        // Cidade + Estado
        grid.add(lblCidade, 0, 6);
        grid.add(cmbCidade, 1, 6);

        grid.add(lblEstado, 2, 6);
        grid.add(txtEstado, 3, 6);

        // Nacionalidade
        grid.add(lblPais, 0, 7);
        grid.add(grupoNaci, 1, 7, 3, 1);

        // Preencher os campos caso seja edição
        if(cliente != null) {
            preencherCliente(cliente);
        }

        // =========================
        // BOTÕES
        // =========================

        Button btnOk = new Button("Ok");
        btnOk.getStyleClass().add("botao-principal");
        btnOk.setOnAction(
                event -> {
                    RadioButton nacionalidade =
                            (RadioButton) grupoNacionalidade.getSelectedToggle();

                    controller.okCliente(


                            StringUtils.vazioParaNulo(txtNome.getText()),
                            StringUtils.vazioParaNulo(txtCpf.getText()),
                            StringUtils.vazioParaNulo(dtNasc.getValue()),
                            StringUtils.vazioParaNulo(txtTelefone.getText()),
                            StringUtils.vazioParaNulo(txtEmail.getText()),
                            StringUtils.vazioParaNulo(txtRua.getText()),
                            StringUtils.vazioParaNulo(txtNumero.getText()),
                            StringUtils.vazioParaNulo(txtComp.getText()),
                            StringUtils.vazioParaNulo(txtBairro.getText()),
                            StringUtils.vazioParaNulo(cmbCidade.getValue()),
                            StringUtils.vazioParaNulo(txtEstado.getText()),
                            StringUtils.vazioParaNulo(nacionalidade.getText()),
                            event
                    );
                }
        );

        Button btnSalvar = new Button("Salvar");
        btnSalvar.getStyleClass().add("botao-secundario");
        btnSalvar.setOnAction(
                event ->
                {
                    RadioButton nacionalidade =
                            (RadioButton) grupoNacionalidade.getSelectedToggle();

                    if (cliente == null) {

                        controller.salvarCliente(
                                StringUtils.vazioParaNulo(txtNome.getText()),
                                StringUtils.vazioParaNulo(txtCpf.getText()),
                                StringUtils.vazioParaNulo(dtNasc.getValue()),
                                StringUtils.vazioParaNulo(txtTelefone.getText()),
                                StringUtils.vazioParaNulo(txtEmail.getText()),
                                StringUtils.vazioParaNulo(txtRua.getText()),
                                StringUtils.vazioParaNulo(txtNumero.getText()),
                                StringUtils.vazioParaNulo(txtComp.getText()),
                                StringUtils.vazioParaNulo(txtBairro.getText()),
                                StringUtils.vazioParaNulo(cmbCidade.getValue()),
                                StringUtils.vazioParaNulo(txtEstado.getText()),
                                StringUtils.vazioParaNulo(nacionalidade.getText())
                        );

                    } else {

                        controller.editarCliente(
                                cliente.getId(),
                                StringUtils.vazioParaNulo(txtNome.getText()),
                                StringUtils.vazioParaNulo(txtCpf.getText()),
                                StringUtils.vazioParaNulo(dtNasc.getValue()),
                                StringUtils.vazioParaNulo(txtTelefone.getText()),
                                StringUtils.vazioParaNulo(txtEmail.getText()),
                                StringUtils.vazioParaNulo(txtRua.getText()),
                                StringUtils.vazioParaNulo(txtNumero.getText()),
                                StringUtils.vazioParaNulo(txtComp.getText()),
                                StringUtils.vazioParaNulo(txtBairro.getText()),
                                StringUtils.vazioParaNulo(cmbCidade.getValue()),
                                StringUtils.vazioParaNulo(txtEstado.getText()),
                                StringUtils.vazioParaNulo(nacionalidade.getText())
                        );
                    }
                }
        );

        Button btnCancelar = new Button("Cancelar");
        btnCancelar.getStyleClass().add("botao-secundario");
        btnCancelar.setOnAction(
                controller::fechar
        );

        btnOk.setMaxWidth(Double.MAX_VALUE);
        btnSalvar.setMaxWidth(Double.MAX_VALUE);
        btnCancelar.setMaxWidth(Double.MAX_VALUE);

        // =========================
        // ÁREA DOS BOTÕES
        // =========================

        VBox botoes = new VBox(10);
        botoes.setAlignment(Pos.CENTER_RIGHT);

        botoes.getChildren().addAll(
                btnOk,
                btnSalvar,
                btnCancelar
        );

        // =========================
        // CONTAINER DA TELA
        // =========================

        VBox root = new VBox(10);

        root.setPadding(new Insets(30));
        root.getChildren().addAll(
                lblTitulo,
                grid,
                botoes
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
                        .getResource("/css/cliente.css")
                        .toExternalForm()
        );
    }

    private void preencherCliente(Cliente cliente) {
        txtNome.setText(cliente.getNome());
        txtCpf.setText(cliente.getCpf());
        txtTelefone.setText(cliente.getTelefone());
        txtEmail.setText(cliente.getEmail());

        dtNasc.setValue(cliente.getDataNasc());

        txtRua.setText(cliente.getRua());
        txtNumero.setText(cliente.getNumero());
        txtComp.setText(cliente.getCompl());
        txtBairro.setText(cliente.getBairro());

        cmbCidade.setValue(cliente.getCidade());

        txtEstado.setText(cliente.getEstado());

        if(cliente.getPais()){
            rbBrasileiro.setSelected(true);
        } else  {
            rbEstrangeiro.setSelected(true);
        }
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Scene getScene() {
        return scene;
    }

}