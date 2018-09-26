package main.baselayouts;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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
    private Stage createStage;

    public MainController() {
    }

    @FXML
    private void initialize() {
        Envelope envelope = new Envelope("here", Envelope.EnvelopeCat.CREDITCARD, 1000,
                true);
        envelopes = new Envelopes(FXCollections.observableArrayList());
        envelopes.add(envelope);
        displayedEnvelopes.setCellFactory(envelopes -> new EnvelopeListItem());
        displayedEnvelopes.setItems(envelopes.getList());
        handleAddButtonAction();
    }

    @FXML
    private void handleAddButtonAction() {
        addButton.setOnAction(event -> {
            CreateEnvelopeDialogBox();
        });
    }

    private void CreateEnvelopeDialogBox() {
        if (envelopeController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/main/listdata/CreateEnvelope.fxml"));
                Parent root = loader.load();
                envelopeController = loader.getController();
                envelopeController.injectMainController(this);
                Scene scene = new Scene(root);
                this.createStage = new Stage();
                createStage.initOwner(primaryStage);
                createStage.setScene(scene);
                envelopeController.injectStage(createStage);
                createStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            createStage.show();
        }
    }


    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setMainApp(Main main) {
        this.main = main;
    }


    public void addEnvelope(Envelope envelope) {
        envelopes.add(envelope);
    }

    /**
     * Displays full UI for the list items
     **/
    private static class EnvelopeListItem extends ListCell<Envelope> {
        HBox hbox = new HBox();
        Label name = new Label("empty");
        Label fundsLeft = new Label("empty");
        Pane pane = new Pane();
        Button moreButton = new Button("More");
        Button payButton = new Button("Pay");
        ProgressBar progressBar = new ProgressBar();
        Envelope envelope;

        public EnvelopeListItem() {
            super();
            hbox.setSpacing(25);
            progressBar.setPrefWidth(300);
            hbox.getChildren().addAll(name, pane, progressBar, fundsLeft, payButton, moreButton);
            HBox.setHgrow(pane, Priority.ALWAYS);
            moreButton.setOnAction(clickEvent -> showEnvelopeDetails());
            payButton.setOnAction(clickEvent -> showPaymentDialog());
        }

        private void showPaymentDialog() {

        }

        private void showEnvelopeDetails() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("details will show in here");
            alert.showAndWait();
        }

        @Override
        protected void updateItem(Envelope item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);
            if (empty) {
                envelope = null;
                setGraphic(null);
            } else {
                envelope = item;
                progressBar.setProgress(envelope.getTotalFunds());
                name.setText(item != null ? item.getName() : "<null>");
                String fundsLeftString = Integer.toString(item.getRemainingFunds());
                fundsLeft.setText(item != null ? fundsLeftString : "<null>");
                setGraphic(hbox);
            }
        }
    }

}
