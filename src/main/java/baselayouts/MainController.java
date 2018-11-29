package main.java.baselayouts;

import javafx.beans.binding.DoubleBinding;
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
import main.java.Main;
import main.java.envelopedata.Envelope;
import main.java.envelopedata.CreateEnvelopeController;
import main.java.envelopedata.Envelopes;

import java.io.IOException;
import java.util.Optional;

public class MainController {

    private Stage primaryStage;
    private Main main;

    @FXML
    private Button addButton;

    @FXML
    private Label income;
    @FXML
    private Label currentBalance;
    @FXML
    private Label expectedBalance;

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
                loader.setLocation(getClass().getResource("/main/java/envelopedata/CreateEnvelope.fxml"));
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
    private class EnvelopeListItem extends ListCell<Envelope> {
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
            hbox.setSpacing(5);
            name.setPrefWidth(60);
            progressBar.setPrefWidth(300);
            fundsLeft.setPrefWidth(60);

            hbox.getChildren().addAll(name, pane, progressBar, fundsLeft, payButton, moreButton);
            HBox.setHgrow(pane, Priority.ALWAYS);
            moreButton.setOnAction(clickEvent -> showEnvelopeDetails());
            payButton.setOnAction(clickEvent -> showPaymentDialog());
        }

        private void showPaymentDialog() {
            TextInputDialog paymentDialog = new TextInputDialog();
            paymentDialog.setTitle("Payment");
            paymentDialog.setContentText("Amount: ");
            Optional<String> result = paymentDialog.showAndWait();

            result.ifPresent(userInput -> {
                if (isNumber(result)) {
                    double intResult = Double.parseDouble(result.get());
                    envelope.deductFunds(intResult);
                    displayedEnvelopes.refresh();
                } else{
                    notIntAlertError();
                }
            });
        }

        private void notIntAlertError() {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("can only insert numbers");
            alert.showAndWait();
        }

        private boolean isNumber(Optional<String> result) {
            try{
                double d = Double.parseDouble(result.get());
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
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
                name.setText(item != null ? item.getName() : "<null>");
                String fundsLeftString = Double.toString(item.getRemainingFunds());
                fundsLeft.setText(item != null ? fundsLeftString : "<null>");
                bindProgressBarToRemainingFundsDividedByTotalFunds();
                setGraphic(hbox);
            }
        }

        private void bindProgressBarToRemainingFundsDividedByTotalFunds() {
            if (!progressBar.progressProperty().isBound()) {
                final DoubleBinding remainingDividedByTotalProperty = envelope.remainingFundsProperty()
                        .divide(envelope.totalFundsProperty());
                progressBar.progressProperty().bind(remainingDividedByTotalProperty);
            }
        }
    }
}