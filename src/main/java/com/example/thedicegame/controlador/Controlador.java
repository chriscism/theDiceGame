package com.example.thedicegame.controlador;

import com.example.thedicegame.modelo.EstacionDeTrabajo;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Controlador {
    private List<EstacionDeTrabajo> estaciones;
    private int bolitasProcesadas;
    private int round;

    public Controlador() {
        estaciones = new ArrayList<>();
        bolitasProcesadas = 0;
        round = 0;


        for (int i = 0; i < 10; i++) {
            estaciones.add(new EstacionDeTrabajo());
        }
    }


}
