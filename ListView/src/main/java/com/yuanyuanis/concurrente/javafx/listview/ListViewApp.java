package com.yuanyuanis.concurrente.javafx.listview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ListViewApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ListView<Pelicula> listView = new ListView<>();
        TextField anio = new TextField();
        TextField nombrePelicula = new TextField();
        Button button = new Button("Añadir Película");

        ObservableList<Pelicula> peliculas = FXCollections.observableArrayList();
        listView.setItems(peliculas);

        button.setOnAction(event -> {
            peliculas.add(new Pelicula(anio.getText(), nombrePelicula.getText()));

            // Limpiar campos
            nombrePelicula.clear();
            anio.clear();
        });

        // Añadir película
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(anio, nombrePelicula, button);

        // Listado de películas
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.getChildren().addAll(listView, hBox);

        // Ecenario
        Scene scene = new Scene(root, 300, 500);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}