package com.example.thedicegame.Graficas;

import com.example.thedicegame.modelo.EstacionDeTrabajo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
        graficoDeBarras.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        // si no movió nada
        if (estaciones.isEmpty() || estaciones.get(0).getHistorialMoved().isEmpty()) {
            promedio.setText("Promedio: \n0.0");
            return;
        }

        int turnosJugados = estaciones.get(0).getHistorialMoved().size();
        double sumaTotal = 0;
        int conteoDatos = 0;
        for (int turno = 0; turno < turnosJugados; turno++) {
            int valorTurno = 0;

            if (estacionSeleccionada == -1) {
                for (EstacionDeTrabajo est : estaciones) {
                    valorTurno += viendoMoved ? est.getHistorialMoved().get(turno) : est.getHistorialRolled().get(turno);
                }
            } else {
                EstacionDeTrabajo est = estaciones.get(estacionSeleccionada);
                valorTurno = viendoMoved ? est.getHistorialMoved().get(turno) : est.getHistorialRolled().get(turno);
            }

            series.getData().add(new XYChart.Data<>(String.valueOf(turno + 1), valorTurno));
            sumaTotal += valorTurno;
            conteoDatos++;
        }

        graficoDeBarras.getData().add(series);

        if (conteoDatos > 0) {
            double promedioDatos = sumaTotal / conteoDatos;
            promedio.setText(String.format("Average\n%.1f", promedio));
        }
    }
}
