package com.example.thedicegame.modelo;

import java.util.ArrayList;

public class EstacionDeTrabajo {
    private ColaCircular<ObjetoDeTrabajo> estacion;
    int cantidadDeDados;
    private ArrayList<Dado> dados;

    public EstacionDeTrabajo(){
        estacion = new ColaCircular<>(70);
        dados = new ArrayList<>();
        dados.add(new Dado());
    }

    public ColaCircular<ObjetoDeTrabajo> getEstacion() {
        return estacion;
    }

    public void setEstacion(ColaCircular<ObjetoDeTrabajo> estacion) {
        this.estacion = estacion;
    }
}
