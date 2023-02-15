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

import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CountryController {

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

        // Creamos el servicio
        CountriesService countriesService = new CountriesService();

        // LLamamos a la API
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

        // TODO: Pasar lambda a rxJava. ¿ Tiene sentido ? Quizás por que en este momento solo se procesarían los datos actuales.
        // TODO: Si hubiese una actualización ¿Como se entera la App de que los datos han cambiado ? Mejjj .... autorespuesta.

        // Filtramos con lambda, ya que tenemos cargadas los datos.
        countryData = countryData.stream()
                    .filter(country -> (name == null || country.getName().toLowerCase().contains(name.toLowerCase()))
                            && (region == null || country.getRegion().toLowerCase().contains(region.toLowerCase()))
                            && (independent == null || country.getIndependent().equals(independent)))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));

    }
}
