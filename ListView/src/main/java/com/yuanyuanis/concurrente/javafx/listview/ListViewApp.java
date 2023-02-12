package com.yuanyuanis.concurrente.javafx.listview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        Label anioLabel = new Label("Año");
        Label nombrePeliculaLabel = new Label("Nombre de película");
        Button button = new Button("Añadir Película");

        // Observable list
        ObservableList<Pelicula> peliculas = FXCollections.observableArrayList();
        listView.setItems(peliculas);

        button.setOnAction(event -> {
            if(validarDatosEntrada(anio, nombrePelicula)) {
                peliculas.add(new Pelicula(Integer.valueOf(anio.getText()), nombrePelicula.getText()));

                // Limpiar campos
                nombrePelicula.clear();
                anio.clear();
            }

        });

        // Campo año
        HBox anioHBox = new HBox();
        anioHBox.setPadding(new Insets(8));
        anioHBox.setSpacing(10);
        anioHBox.getChildren().addAll(anioLabel, anio);

        // Campo nombre de película
        HBox nameHBox = new HBox();
        nameHBox.setPadding(new Insets(8));
        nameHBox.setSpacing(10);
        nameHBox.getChildren().addAll(nombrePeliculaLabel, nombrePelicula);

        // Listado de películas
        VBox root = new VBox();
        root.setPadding(new Insets(8));
        root.setSpacing(10);
        root.getChildren().addAll(listView, anioHBox, nameHBox, button );

        // Escenario
        Scene scene = new Scene(root, 410, 520);
        stage.setScene(scene);
        stage.setTitle("App List peliculas observables");
        stage.show();

    }

    private boolean validarDatosEntrada(TextField anio, TextField nombrePelicula) {
        boolean valido = true;
        if(nombrePelicula.getText().isEmpty()){
            nombrePelicula.setText("Error, Introduce un nombre");
            valido = false;
        }
        if(anio.getText().isEmpty()){
            anio.setText("Error, Introduce año");
            valido = false;
        }
        try{
            Integer.parseInt(anio.getText());
        } catch (NumberFormatException e){
            valido = false;
            anio.setText("Error, Introduce año");
        }
        return  valido;
    }

    public static void main(String[] args) {

        launch();
    }
}