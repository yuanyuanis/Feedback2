package com.yuanyuanis.openfoodfactsjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.coderion.model.Nutriments;
import pl.coderion.model.Product;
import pl.coderion.model.ProductResponse;
import pl.coderion.service.OpenFoodFactsWrapper;
import pl.coderion.service.impl.OpenFoodFactsWrapperImpl;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OpenFoodFactJavaFXApp extends Application {

    private TextField barcodeField;
    private Label nameLabel;
    private Label labelError;
    Text nameText;
    private Label genericNameLabel;
    private Label productCodeLabel;
    private Label ingredientsLabel;
    private Label nutrimentsLabel;
    private ImageView imageView;
    private Text nutrimentsText;
    private Text genericNameText;
    private Text productCodeText;
    private Text ingredientsText;
    private Button searchButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        HBox top = createTop();
        root.setTop(top);

        VBox center = createCenter();
        root.setCenter(center);

        Scene scene = new Scene(root, 800, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Open Food Fact JavaFX App");
        primaryStage.show();
    }

    private HBox createTop() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_LEFT);

        barcodeField = new TextField();
        hBox.getChildren().add(barcodeField);

        searchButton = new Button("Buscar");
        hBox.getChildren().add(searchButton);
        searchButton.setOnAction(event -> handleSearchButton());

        Label ejemplosBarcodeLabel = new Label("barcodes ejemplos: ");
        ejemplosBarcodeLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
        hBox.getChildren().add(ejemplosBarcodeLabel);

        Text ejemplosBarcode = new Text("3017620422003, 5449000214911, 3017620425035");
        hBox.getChildren().add(ejemplosBarcode);

        hBox.getChildren().add(createSpacer());
        labelError = new Label();
        hBox.getChildren().add(labelError);

        return hBox;
    }

    private void handleSearchButton() {

        OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();
        ProductResponse productResponse = wrapper.fetchProductByCode(barcodeField.getText());

        if (!productResponse.isStatus()) {

            labelError.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            labelError.setText("Error en la búsqueda");
            System.out.println("Status: " + productResponse.getStatusVerbose());
            return;
        }

        Product product = productResponse.getProduct();
        nameText.setText(product.getProductName());
        genericNameText.setText(product.getGenericName());
        productCodeText.setText(product.getCode());
        String ingredientsAsString = Arrays.stream(product.getIngredients())
                .map(i -> i.getText())
                .collect(Collectors.joining(", "));
        ingredientsText.setText(ingredientsAsString);

        Nutriments nutriments = product.getNutriments();

        StringBuilder builder = new StringBuilder();
        builder.append(String.format(" * Calcium=%s%s", nutriments.getCalciumValue(), nutriments.getCalciumUnit()));
        builder.append("\n");
        builder.append(String.format(" * Sugars=%s%s", nutriments.getSugarsValue(), nutriments.getSugarsUnit()));
        builder.append("\n");
        builder.append(String.format(" * Energy=%skcal", nutriments.getEnergyKcal()));
        nutrimentsText.setText(builder.toString());


        imageView.setImage(new Image(product.getImageUrl()));
    }

    private VBox createCenter() {
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        center.setSpacing(20);

        imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setFitHeight(300);

        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
        nameText = new Text();

        Label genericNameLabel = new Label("Generic name: ");
        genericNameLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
        genericNameText = new Text();

        Label productCodeLabel = new Label("Product code: ");
        productCodeLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
        productCodeText = new Text();

        Label ingredientsLabel = new Label("Ingredients: ");
        ingredientsLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
        ingredientsText = new Text();

        Label nutrimentsLabel = new Label("Nutriments: ");
        nutrimentsLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
        nutrimentsText = new Text();

        center.getChildren().addAll(imageView, nameLabel, nameText, genericNameLabel, genericNameText, productCodeLabel, productCodeText, ingredientsLabel, ingredientsText, nutrimentsLabel, nutrimentsText);

        return center;
    }

    private Region createSpacer() {
        Region spacer = new Region();
        spacer.setMinHeight(10);
        return spacer;
    }
}

