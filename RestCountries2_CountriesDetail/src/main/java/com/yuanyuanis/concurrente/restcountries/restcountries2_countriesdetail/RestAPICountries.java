package com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail;

import com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail.domain.Country;
import com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail.service.CountriesService;
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

        // 1) Observable
        countryData = FXCollections.observableArrayList();

        // 2) Llamada a la API
        CountriesService countriesService = new CountriesService();
        countryData.addAll(countriesService.getAllCountries());

        // 3) mostrar datos en look and feel
        crearLookAndFeel(primaryStage);
    }

    private void crearLookAndFeel(Stage primaryStage) {

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
        primaryStage.setTitle("Lista de Países v2. Detalle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
