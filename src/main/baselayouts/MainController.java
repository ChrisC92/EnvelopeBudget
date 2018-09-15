package main.baselayouts;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import main.listdata.Envelope;
import main.listdata.CreateEnvelopeController;
import main.listdata.Envelopes;

import java.io.IOException;

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

    private CreateEnvelopeController envelopeController;
    private Envelopes envelopes;

    public MainController() {
    }

    @FXML
    private void initialize() {
        envelopes = new Envelopes(FXCollections.observableArrayList());
        displayedEnvelopes.setItems(envelopes.get());
        handleAddButtonAction();
    }

    @FXML
    private void handleAddButtonAction() {
        addButton.setOnAction(event -> {
            CreateEnvelopeDialogBox();

        });
    }

    private void CreateEnvelopeDialogBox() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/main/listdata/CreateEnvelope.fxml"));
            Parent root = loader.load();
            envelopeController = loader.getController();
            envelopeController.injectMainController(this);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initOwner(primaryStage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void setEnvelopeController(CreateEnvelopeController envelopeController) {
        this.envelopeController = envelopeController;
    }

    public void addEnvelope(Envelope envelope) {
        envelopes.add(envelope);
    }
}
