package org.telaCadastro;

import javafx.application.Application;
import javafx.stage.Stage;
import org.telaCadastro.controller.ClienteController;
import org.telaCadastro.view.TelaCadastroView;

public class Main extends Application {


    @Override
    public void start(Stage stage) {
        ClienteController controller = new ClienteController();

        TelaCadastroView view = new TelaCadastroView(controller);

        stage.setScene(view.getScene());
        stage.setTitle("Questão de Modas");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
