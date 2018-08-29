package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.Main;
import main.model.Envelope;

public class MainController {

    private Stage primaryStage;
    private Main main;

    @FXML
    private Button addButton;

    @FXML
    private TextField income;
    @FXML
    private TextField currentBalance;
    @FXML
    private TextField expectedBalance;

    @FXML
    private ListView<Envelope> displayedEnvelopes;
    private ObservableList<Envelope> envelopes;
    // For testing delete when needed
    private int counter;




    public MainController() {
    }

    @FXML
    private void initialize() {
        envelopes = FXCollections.observableArrayList();
        displayedEnvelopes.setItems(envelopes);
        initializeLists();
        handleAddButtonAction();
    }

    private void initializeLists() {
        displayedEnvelopes.setCellFactory(new Callback<ListView<Envelope>, ListCell<Envelope>>() {
            @Override
            public ListCell<Envelope> call(ListView<Envelope> param) {
                return new ListCell<Envelope>() {
                    @Override
                    public void updateItem(Envelope envelope, boolean empty) {
                        super.updateItem(envelope, empty);
                        if(envelope == null) {
                            setText(null);
                        } else {
                            setText(envelope.getName());
                        }
                    }
                };
            }
        });
    }

    private void handleAddButtonAction() {
        addButton.setOnAction((ActionEvent event) -> {
            envelopes.add(new Envelope("envelope: " + counter));
            counter +=1;
        } );
    }

    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
