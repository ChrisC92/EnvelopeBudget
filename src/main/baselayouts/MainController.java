package main.baselayouts;

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
import main.listdata.DisplayEnvelope;
import main.listdata.Envelope;
import main.listdata.EnvelopeController;
import main.listdata.Envelopes;

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

    private EnvelopeController envelopeController;
    private Envelopes envelopes;

    public int counter = 0;


    public MainController() {
    }

    @FXML
    private void initialize() {
        envelopes = new Envelopes(FXCollections.observableArrayList());
        displayedEnvelopes.setItems(envelopes.get());

        envelopeController = new EnvelopeController();
        envelopeController.setEnvelopeList(displayedEnvelopes);
        handleAddButtonAction();
    }

    @FXML
    private void handleAddButtonAction() {
        addButton.setOnAction((ActionEvent event) -> {
            envelopes.get().add(new Envelope("envelope: "  + counter));
            counter++;
            displayedEnvelopes.setCellFactory(new Callback<ListView<Envelope>, ListCell<Envelope>>() {
                @Override
                public ListCell<Envelope> call(ListView<Envelope> param) {
                    return new DisplayEnvelope();
                }
            });
        });
    }

    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void setEnvelopeController(EnvelopeController controller) {
        envelopeController = controller;
    }
}
