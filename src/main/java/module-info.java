module com.example.thedicegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.thedicegame to javafx.fxml;
    exports com.example.thedicegame;
}