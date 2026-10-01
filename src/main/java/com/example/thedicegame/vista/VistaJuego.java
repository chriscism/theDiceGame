package com.example.thedicegame.vista;

import com.example.thedicegame.controlador.Controlador;
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

    }

    private VBox crearParteDerecha(){
        
    }
}
