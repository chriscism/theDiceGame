package com.example.thedicegame.modelo;

import java.util.ArrayList;
import java.util.List;

public class EstacionDeTrabajo {
    private ColaCircular<ObjetoDeTrabajo> estacion;
    private ArrayList<Dado> dados;

    public EstacionDeTrabajo(){
        estacion = new ColaCircular<>(70);
        dados = new ArrayList<>();
        dados.add(new Dado());
    }



    public ColaCircular<ObjetoDeTrabajo> getEstacion() {
        return estacion;
    }

    public void anadirDado(Dado dado){
        dados.add(dado);
    }

    public boolean quitarDado(){
        if(!dados.isEmpty()){
            dados.removeLast();
            return true;
        }
        return false;
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
            ObjetoDeTrabajo objeto = estacion.eliminarDato();
            if(objeto == null) break; // por si el dado sale mayor que el numero de bolitas que hay en la estacion
            bolitas.add(objeto);
        }
        return  bolitas;
    }

    public void recibirBolitas(List<ObjetoDeTrabajo> bolitas){
        for(int i = 0; i < bolitas.size(); i++){
            estacion.insertarDato(bolitas.get(i));
        }
    }

    public void recibirBolitas(int numBolitas){
        for(int i = 0; i < numBolitas; i++)
            estacion.insertarDato(new ObjetoDeTrabajo());
    }

    public int obtenerSumatoriaDeLosDados(){
        return  dados.stream().mapToInt(Dado::getValorActual).reduce(0, Integer::sum);
    }

    public int getCantidadDeDados(){
        return dados.size();
    }

    public List<Dado> getDados(){
        return dados;
    }
}
