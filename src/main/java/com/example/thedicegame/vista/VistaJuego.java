package com.example.thedicegame.vista;

import com.example.thedicegame.controlador.Controlador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaJuego extends BorderPane {
    private Controlador controlador;
    private Label labelTurno;

    public VistaJuego(){
        controlador = new Controlador();
        labelTurno = new Label("Turno: ");
        labelTurno.setStyle("-fx-text-fill: white;" +
                " -fx-font-size: 16px;" +
                " -fx-text-alignment: center;");
        setRight(crearParteDerecha());
        setCenter(tableroDeJuego());
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

        menu.getChildren().addAll(btnActivity, btnThroughput, btnSystemNum, btnSystemTime, new Region(), labelTurno, btnRoll);
        VBox.setVgrow(menu.getChildren().get(4), Priority.ALWAYS);
        return  menu;
    }

    private GridPane tableroDeJuego(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);
        grid.setVgap(40);
        grid.setStyle("-fx-background-color: #e8e4d9;");

        grid.add(crearEstacionesProvisionales(), 0, 0);
        grid.add(crearEstacionesProvisionales(), 1, 0);
        grid.add(crearEstacionesProvisionales(), 2, 0);
        grid.add(crearEstacionesProvisionales(), 3, 0);
        grid.add(crearEstacionesProvisionales(), 3, 1);
        grid.add(crearEstacionesProvisionales(), 0, 1);
        grid.add(crearEstacionesProvisionales(), 0, 2);
        grid.add(crearEstacionesProvisionales(), 3, 2);
        grid.add(crearEstacionesProvisionales(), 1, 2);
        grid.add(crearEstacionesProvisionales(), 2, 2);

        return  grid;
    }

    // NO PUEDO CAMBIAR LOS RECTANGULOS POR EMOJIS, LUEGO LO REVISO
    private VBox  crearEstacionesProvisionales(){
        VBox caja = new VBox(5);
        caja.setAlignment(Pos.CENTER);

        Rectangle dibujoDelMonito = new Rectangle(50, 50, Color.LIGHTBLUE);

        caja.getChildren().addAll(dibujoDelMonito);
        return caja;
    }
}
