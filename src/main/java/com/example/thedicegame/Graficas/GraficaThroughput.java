package com.example.thedicegame.Graficas;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;

public class GraficaThroughput extends Stage {
    public GraficaThroughput(List<Integer> historial){
        CategoryAxis ejeX = new CategoryAxis();
        ejeX.setLabel("Turno");

        NumberAxis ejeY = new NumberAxis();
        ejeY.setLabel("Bolas procesadas");

        BarChart<String, Number> graficoDeBarras = new BarChart<>(ejeX, ejeY);
        graficoDeBarras.setLegendVisible(false);
        graficoDeBarras.setStyle("-fx-bar-fill: #00bfff;");

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        int turno = 1;
        for (Integer valor : historial) {
            series.getData().add(new XYChart.Data<>(String.valueOf(turno), valor));
            turno++;
        }

        graficoDeBarras.getData().add(series);

        Scene scene = new Scene(graficoDeBarras, 800, 500);
        setScene(scene);
    }
}
