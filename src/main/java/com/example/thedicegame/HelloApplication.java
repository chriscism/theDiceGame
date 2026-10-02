package com.example.thedicegame;

import com.example.thedicegame.vista.VistaJuego;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VistaJuego vistaJuego = new VistaJuego();
        Scene scene = new Scene(vistaJuego, 1000, 600);
        stage.setTitle("THE DICE GAME 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
