package com.yuanyuanis.concurrente.restcountriesv3.controller;

import com.yuanyuanis.concurrente.restcountriesv3.domain.Country;
import com.yuanyuanis.concurrente.restcountriesv3.service.CountriesService;
import rx.Observable;
import rx.schedulers.Schedulers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.concurrent.Executors;

public class CountryController {

    private CountriesService countriesService = new CountriesService();

    private ObservableList<Country> countryData;
    @FXML private TableView<Country> countryTable;
    @FXML private TextField nameField;
    @FXML private TextField regionField;
    @FXML private CheckBox independentCheckBox;

    @FXML
    private TableColumn<Country, String> nameColumn;

    @FXML
    private TableColumn<Country, String> capitalColumn;

    @FXML
    private TableColumn<Country, String> regionColumn;

    @FXML
    private TableColumn<Country, String> subregionColumn;

    @FXML
    private TableColumn<Country, Boolean> independentColumn;

    @FXML
    private TableColumn<Country, Integer> populationColumn;

    @FXML
    public void initialize() {

        // 1) Observable
        countryData = FXCollections.observableArrayList();

        // LLamamos inicial a la API
        countriesService.getAllCountries()
                .flatMap(Observable::from)
                .doOnCompleted(() -> System.out.println("Listado de países descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(countries -> {
                    // 3) Ponemos los datos.
                    countryData.addAll(countries);
                });


        // 4) Añadir a la tabla
        countryTable.setItems(countryData);
    }

    public void handleSearchButton(ActionEvent actionEvent) {
        String name = nameField.getText();
        Boolean independent = independentCheckBox.isSelected();
        String region = regionField.getText();

        countriesService.getAllCountries()
                .subscribeOn(Schedulers.io())
                .flatMap(Observable::from)
                .filter(country -> {
                    boolean existeName = true;
                    boolean existeIndependent = true;
                    boolean existeRegion = true;

                    if (!name.isEmpty()) {
                        existeName = country.getName().toLowerCase().contains(name.toLowerCase());
                    }

                    if (!region.isEmpty()) {
                        existeRegion = country.getRegion().toLowerCase().contains(region.toLowerCase());
                    }

                    if (independent != null) {
                        existeIndependent = country.getIndependent() == independent;
                    }

                    return existeName && existeIndependent && existeRegion;
                })
                .toList()
                .subscribe(paisesFiltrados -> {
                    // Pasamos a observable los países filtrados
                    countryData = FXCollections.observableArrayList(paisesFiltrados);

                    // Establecemos los países en su tabla
                    countryTable.setItems(countryData);
                });


    }
}
