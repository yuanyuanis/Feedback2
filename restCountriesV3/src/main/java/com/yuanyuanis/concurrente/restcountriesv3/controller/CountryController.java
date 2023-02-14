package com.yuanyuanis.concurrente.restcountriesv3.controller;

import com.yuanyuanis.concurrente.restcountriesv3.domain.Country;
import com.yuanyuanis.concurrente.restcountriesv3.service.CountriesService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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

        // 2) Llamada a la API
        CountriesService countriesService = new CountriesService();
        countryData.addAll(countriesService.getAllCountries());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        capitalColumn.setCellValueFactory(new PropertyValueFactory<>("capital"));
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
        subregionColumn.setCellValueFactory(new PropertyValueFactory<>("subregion"));
        independentColumn.setCellValueFactory(new PropertyValueFactory<>("independent"));
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("population"));
    }

    @FXML
    public void handleSearchAction() {


    }

    public void handleSearchButton(ActionEvent actionEvent) {
        String name = nameField.getText();
        boolean independent = independentCheckBox.isSelected();
        String region = regionField.getText();

        // 1) Observable
        countryData = FXCollections.observableArrayList();

        // 2) Llamada a la API
        CountriesService countriesService = new CountriesService();
        countryData.addAll(countriesService.getAllCountries());
    }
}
