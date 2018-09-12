package examplecode;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ListViewSample extends Application {
    private ListView<Product> productsListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("List View Sample");

        ObservableList<Product> products = createProducts();
        ListView<Product> listView = createProductsListView(products);

        Scene listViewScene = new Scene(listView,350,100);
        primaryStage.setScene(listViewScene);
        primaryStage.show();
    }

    public ListView<Product> createProductsListView(ObservableList<Product> products) {
        productsListView = new ListView<>();
        productsListView.setCellFactory(listView -> new ProductListItem());
        productsListView.setItems(products);
        return productsListView;
    }

    private ObservableList<Product> createProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Apple", "A kind of fruit."));
        products.add(new Product("Beer", "Something to drink."));
        return products;
    }

    private class ProductListItem extends ListCell<Product> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        Button detailsButton = new Button("Details");
        Product product;

        public ProductListItem() {
            super();
            hbox.getChildren().addAll(label, pane, detailsButton);
            HBox.setHgrow(pane, Priority.ALWAYS);
            detailsButton.setOnAction(clickEvent -> showProductDetails());
        }

        private void showProductDetails() {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(product.getName());
            alert.setHeaderText(null);
            alert.setContentText(product.getDetails());
            alert.showAndWait();
        }

        @Override
        protected void updateItem(Product item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);
            if (empty) {
                product = null;
                setGraphic(null);
            } else {
                product = item;
                label.setText(item != null ? item.getName() : "<null>");
                setGraphic(hbox);
            }
        }
    }

    private class Product {
        private String name;
        private String details;

        public Product(String name, String details) {
            this.name = name;
            this.details = details;
        }

        public String getName() {
            return name;
        }

        public String getDetails() {
            return details;
        }
    }
}