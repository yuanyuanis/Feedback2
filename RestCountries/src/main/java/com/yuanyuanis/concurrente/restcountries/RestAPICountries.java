package com.yuanyuanis.concurrente.restcountries;

import com.yuanyuanis.concurrente.restcountries.domain.Country;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestAPICountries extends Application {

    private TableView<Country> table;
    private ObservableList<Country> countryData;

    public void start(Stage primaryStage) {
        // Crear los objetos de país y agregarlos a la lista
        countryData = FXCollections.observableArrayList();
        countryData.add(new Country("Argentina","Buenos Aires", "Americas", "South America", true, 44938712));
        countryData.add(new Country("Brasil","Brasilia", "Americas", "South America", true, 211755692));
        countryData.add(new Country("España","Madrid", "Europe", "Southern Europe", true, 47329981));
        countryData.add(new Country("Italia","Roma", "Europe", "Southern Europe", true, 60359546));
        countryData.add(new Country("Nosee","Canberra", "Oceania", "Australia and New Zealand", true, 25755309));
        countryData.add(new Country("Japon","Tokyo", "Asia", "Eastern Asia", true, 1264764612));

        // Crear las columnas de la tabla y asociarlas con los campos de país

        TableColumn<Country, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Country, String> capitalCol = new TableColumn<>("Capital");
        capitalCol.setCellValueFactory(new PropertyValueFactory<>("capital"));

        TableColumn<Country, String> regionCol = new TableColumn<>("Region");
        regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));

        TableColumn<Country, String> subregionCol = new TableColumn<>("Subregion");
        subregionCol.setCellValueFactory(new PropertyValueFactory<>("subregion"));

        TableColumn<Country, Boolean> independentCol = new TableColumn<>("Independent");
        independentCol.setCellValueFactory(new PropertyValueFactory<>("independent"));

        TableColumn<Country, Integer> populationCol = new TableColumn<>("Population");
        populationCol.setCellValueFactory(new PropertyValueFactory<>("population"));

        // Crear la tabla y agregar las columnas
        table = new TableView<>();
        table.setItems(countryData);
        table.getColumns().addAll(nameCol, capitalCol, regionCol, subregionCol, independentCol, populationCol);

        // Crear el contenedor principal de la GUI y agregar la tabla
        VBox root = new VBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().add(table);

        // Crear la escena y mostrar la ventana
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lista de Países");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
