package com.example.thedicegame.controlador;

import com.example.thedicegame.modelo.EstacionDeTrabajo;
import com.example.thedicegame.modelo.ObjetoDeTrabajo;

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
        distribucionInicialDeBolitas();
    }

    public void distribucionInicialDeBolitas(){
        for(int i = 1; i < estaciones.size(); i++)
            estaciones.get(i).recibirBolitas(4);
    }

    public void ronda(){
        round++;
        for (int i = estaciones.size() - 1; i >= 0; i--) {
            EstacionDeTrabajo estacionActual = estaciones.get(i);
            int bolitasAPasar = estacionActual.tirarDados();

            // esto se hace porque la primera estacion va a recibir siempre la cantidad necesaria
            if (i == 0) {
                List<ObjetoDeTrabajo> bolitasInfinitas = new ArrayList<>();
                for (int j = 0; j < bolitasAPasar; j++) {
                    bolitasInfinitas.add(new ObjetoDeTrabajo());
                }
                estacionActual.recibirBolitas(bolitasInfinitas);
            }
            List<ObjetoDeTrabajo> bolitas = estacionActual.pasarBolitas(bolitasAPasar);

            // como es la ultima estacion, sale del ciclo y se pasa al total procesado
            if (i == estaciones.size() - 1) {
                bolitasProcesadas += bolitas.size();
            } else {
                // sino, se las pasa a la siguiente estacion
                estaciones.get(i + 1).recibirBolitas(bolitas);
            }
        }
    }

    public List<EstacionDeTrabajo> getEstaciones() {
        return estaciones;
    }

    public EstacionDeTrabajo getEstacion(int index){
        return estaciones.get(index);
    }

    public void setEstaciones(List<EstacionDeTrabajo> estaciones) {
        this.estaciones = estaciones;
    }

    public int getBolitasProcesadas() {
        return bolitasProcesadas;
    }

    public void setBolitasProcesadas(int bolitasProcesadas) {
        this.bolitasProcesadas = bolitasProcesadas;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
