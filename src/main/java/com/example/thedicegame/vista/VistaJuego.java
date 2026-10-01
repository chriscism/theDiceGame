package com.example.thedicegame.vista;

import com.example.thedicegame.controlador.Controlador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaJuego extends BorderPane {
    private Controlador controlador;
    private Label labelTurno;

    public VistaJuego(){
        controlador = new Controlador();
        labelTurno = new Label("Turno: ");
        labelTurno.setStyle("-fx-text-fill: white;" +
                " -fx-font-size: 16px;" +
                " -fx-text-alignment: center;");

    }

    private VBox crearParteDerecha(){
        VBox menu = new VBox(20);
        menu.setPadding(new Insets(20));
        menu.setStyle("-fx-background-color: #3b2a2a;");
        menu.setPrefWidth(200);
        menu.setAlignment(Pos.CENTER);

        Button btnActivity = new Button("Activity");
        Button btnThroughput = new Button("Throughput");
        Button btnSystemNum = new Button("Number in system");
        Button btnSystemTime = new Button("Time in system");
        Button btnRoll = new Button("Roll");
        btnRoll.setPrefSize(100, 50);
        btnRoll.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        btnActivity.setMaxWidth(Double.MAX_VALUE);
        btnThroughput.setMaxWidth(Double.MAX_VALUE);
        btnSystemNum.setMaxWidth(Double.MAX_VALUE);
        btnSystemTime.setMaxWidth(Double.MAX_VALUE);

        btnRoll.setOnAction(e -> {
            controlador.ronda();
            labelTurno.setText("Turns\n" + controlador.getRound());
            System.out.println("Ronda " + controlador.getRound() + " completada.");
        });
    }
}
