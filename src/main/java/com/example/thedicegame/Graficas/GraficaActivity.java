package com.example.thedicegame.Graficas;

import com.example.thedicegame.modelo.EstacionDeTrabajo;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;

import java.util.List;

public class GraficaActivity {
    private List<EstacionDeTrabajo> estaciones;
    private BarChart<String, Number> barChart;
    private Label lblAverage;
    private int estacionSeleccionada = -1; // all
    private boolean viendoMoved = true; // true moved, false rolled


}
