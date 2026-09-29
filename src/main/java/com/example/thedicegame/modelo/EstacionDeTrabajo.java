package com.example.thedicegame.modelo;

import java.util.ArrayList;
import java.util.List;

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

    public int tirarDados(){
        for (Dado d:dados)
            d.lanzar();
        return  obtenerSumatoriaDeLosDados();
    }

    public List<ObjetoDeTrabajo> pasarBolitas(int numBolitas){
        ArrayList<ObjetoDeTrabajo> bolitas = new ArrayList<>();
        for(int i = 0; i < numBolitas; i++){
            bolitas.add(estacion.eliminarDato());
        }
        return  bolitas;
    }

    public void recibirBolitas(int numBolitas){
        for(int i = 0; i < numBolitas; i++){
            estacion.insertarDato(new ObjetoDeTrabajo());
        }
    }

    private int obtenerSumatoriaDeLosDados(){
        return  dados.stream().mapToInt(Dado::getValorActual).reduce(0, Integer::sum);
    }
}
