package com.yuanyuanis.concurrente.feedback2.observer.listView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ListView<String> listView = new ListView<>();
        TextField textField = new TextField();
        Button addButton = new Button("Add");

        ObservableList<String> items = FXCollections.observableArrayList();
        listView.setItems(items);

        addButton.setOnAction(event -> {
            String item = textField.getText();
            items.add(item);
            textField.clear();
        });

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.getChildren().addAll(listView, textField, addButton);

        Scene scene = new Scene(root, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
