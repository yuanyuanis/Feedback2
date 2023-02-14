package com.yuanyuanis.concurrente.restcountries;

import com.yuanyuanis.concurrente.restcountries.domain.Country;
import com.yuanyuanis.concurrente.restcountries.service.CountriesService;
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

        CountriesService countriesService = new CountriesService();
        countryData.addAll(countriesService.getAllCountries());

        // La vista en JavaFX
        crearLookAndFeel(primaryStage);
    }

    private void crearLookAndFeel(Stage primaryStage) {

        // Crear las columnas de la tabla y asociarlas con los campos de país
        TableColumn<Country, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Crear la tabla y agregar las columnas
        table = new TableView<>();
        table.setItems(countryData);
        table.getColumns().addAll(nameCol);

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
