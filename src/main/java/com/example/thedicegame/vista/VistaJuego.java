package com.example.thedicegame.vista;

import com.example.thedicegame.controlador.Controlador;
import com.example.thedicegame.modelo.Dado;
import com.example.thedicegame.modelo.EstacionDeTrabajo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class VistaJuego extends BorderPane {
    private Controlador controlador;
    private Label labelTurno;
    private List<Runnable> actualizadoresDePantalla;

    public VistaJuego(){
        actualizadoresDePantalla = new ArrayList<>();
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
            if(controlador.getRound()< 20) {
                controlador.ronda();
                labelTurno.setText("TURNO:\n" + controlador.getRound());
                System.out.println("Ronda " + controlador.getRound() + " completada.");
                for (Runnable actualizador : actualizadoresDePantalla) {
                    actualizador.run();
                }
            }
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

        grid.add(crearEstacion(0), 0, 0);
        grid.add(crearEstacion(1), 1, 0);
        grid.add(crearEstacion(2), 2, 0);
        grid.add(crearEstacion(3), 3, 0);
        grid.add(crearEstacion(4), 3, 1);
        grid.add(crearEstacion(5), 0, 1);
        grid.add(crearEstacion(6), 0, 2);
        grid.add(crearEstacion(7), 3, 2);
        grid.add(crearEstacion(8), 1, 2);
        grid.add(crearEstacion(9), 2, 2);

        return  grid;
    }

    // NO PUEDO CAMBIAR LOS RECTANGULOS POR EMOJIS, LUEGO LO REVISO
    /*
    private VBox  crearEstacionesProvisionales(){
        VBox caja = new VBox(5);
        caja.setAlignment(Pos.CENTER);

        Rectangle dibujoDelMonito = new Rectangle(50, 50, Color.LIGHTBLUE);

        caja.getChildren().addAll(dibujoDelMonito);
        return caja;
    }

     */

    private StackPane generarDados(Dado dado) {
        StackPane dadoContenedor = new StackPane();
        Rectangle fondo = new Rectangle(30, 30, Color.RED);
        fondo.setArcWidth(8);
        fondo.setArcHeight(8);

        FlowPane contenedorBolitas = new FlowPane();
        contenedorBolitas.setAlignment(Pos.CENTER);
        contenedorBolitas.setHgap(3);
        contenedorBolitas.setVgap(3);
        contenedorBolitas.setPrefWrapLength(60);
        contenedorBolitas.setMinHeight(30);

        Text textoValor = new Text(String.valueOf(dado.getValorActual()));
        textoValor.setStyle("-fx-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");
        dadoContenedor.getChildren().addAll(fondo, textoValor);
        return dadoContenedor;
    }

    private VBox crearEstacion(int index){
        VBox caja = new VBox(5);
        caja.setAlignment(Pos.CENTER);

        EstacionDeTrabajo estacion = controlador.getEstacion(index);
        HBox contenedorDados = new HBox(5);
        contenedorDados.setAlignment(Pos.CENTER);
        contenedorDados.setPrefHeight(40);

        Runnable actualizarDados = () -> {
            contenedorDados.getChildren().clear();
            for(Dado d:estacion.getDados()){
                contenedorDados.getChildren().add(generarDados(d));
            }
        };
        actualizadoresDePantalla.add(actualizarDados);
        actualizarDados.run();
        Button botonmas = new Button("+");
        Button botonMenos = new Button("-");
        botonMenos.setOnAction(event -> {
            if (estacion.getCantidadDeDados() > 0) {
                estacion.quitarDado();
                controlador.meterDado();
                actualizarDados.run();
            }
        });
        botonmas.setOnAction(event -> {
            if (controlador.tomarDado()) {
                estacion.anadirDado(new Dado());
                actualizarDados.run();
            }
        });
        HBox controles = new HBox(5, botonmas, botonMenos);
        controles.setAlignment(Pos.CENTER);
        caja.getChildren().addAll(contenedorDados, controles);
        return caja;
    }

    public Circle dibujarBolita(){
        Circle bolita = new Circle(5, Color.BLUE);
        return  bolita;
    }
}
