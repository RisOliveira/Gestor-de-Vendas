package org.telaCadastro.util;

import javafx.scene.Scene;

public class StyleManager {
    public static void aplicarGlobais(Scene scene) {

        scene.getStylesheets().add(
                StyleManager.class
                        .getResource("/css/global.css")
                        .toExternalForm()
        );

        scene.getStylesheets().add(
                StyleManager.class
                        .getResource("/css/componente.css")
                        .toExternalForm()
        );
    }

    public static void aplicarTela(Scene scene, String nomeCss) {

        scene.getStylesheets().add(
                StyleManager.class
                        .getResource("/css/" + nomeCss)
                        .toExternalForm()
        );
    }
}
