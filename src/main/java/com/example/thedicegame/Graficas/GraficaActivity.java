package com.example.thedicegame.Graficas;

import com.example.thedicegame.modelo.EstacionDeTrabajo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class GraficaActivity {
    private List<EstacionDeTrabajo> estaciones;
    private BarChart<String, Number> graficoDeBarras;
    private Label promedio;
    private int estacionSeleccionada = -1; // all
    private boolean viendoMoved = true; // true moved, false rolled


    public GraficaActivity(List<EstacionDeTrabajo> estaciones){
        this.estaciones = estaciones;
        graficoDeBarras.setTitle("Gráficas de actividad por estaciones");
        BorderPane layout = new BorderPane();
        layout.setStyle("-fx-background-color: #d1cbbd;");
        CategoryAxis ejeX = new CategoryAxis();
        ejeX.setLabel("Turno");
        NumberAxis ejeY = new NumberAxis();
        ejeY.setLabel("Número");

        graficoDeBarras = new BarChart<>(ejeX, ejeY);
        graficoDeBarras.setLegendVisible(false);
        graficoDeBarras.setStyle("-fx-bar-fill: #00bfff;"); // Barras azules

        VBox panelDerecho = new VBox(20);
        panelDerecho.setAlignment(Pos.CENTER);
        panelDerecho.setPadding(new Insets(10));

        Button btnMoved = new Button("Moved");
        Button btnRolled = new Button("Rolled");
        promedio = new Label("Average\n0.0");
        promedio.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
    }

    private void actualizarGrafica(){

    }
}
