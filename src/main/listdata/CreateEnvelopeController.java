package main.listdata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.Main;
import main.baselayouts.MainController;

import java.io.IOException;


public class CreateEnvelopeController {

    private Main main;

    private Stage stage;
    @FXML
    private TextField envelopeName;
    @FXML
    private TextField total;
    @FXML
    private ChoiceBox<Envelope.EnvelopeCat> type;
    @FXML
    private ChoiceBox<String> stickied;
    @FXML
    private Button confirmButton;

    private ListView<Envelope> envelopeListView;
    private MainController mainController;

    public CreateEnvelopeController() {
    }

    @FXML
    private void initialize() {
        dialogButtonAction();
        populateChoiceBoxes();
        populateDialogTesting();
    }

    private void populateDialogTesting() {
        envelopeName = new TextField("test");
        total = new TextField("100");
        type.setValue(Envelope.EnvelopeCat.CREDITCARD);
        stickied.setValue("recurring");

    }

    public void setEnvelopeList(ListView<Envelope> envelopeList) {
        envelopeListView = envelopeList;
    }

    public void inputEnvelopeData(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/listdata/CreateEnvelope.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage();
            stage.initOwner(primaryStage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void dialogButtonAction() {
        confirmButton.setOnAction(event -> {
            if (incompleteForm()) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setContentText("Fields have not been completed");
                error.showAndWait();
            } else {
                int totalInt = Integer.parseInt(total.getText());
                mainController.addEnvelope(new Envelope(envelopeName.getText(), type.getValue(), totalInt, isRecurring()));
            }
        });
    }

    private boolean isRecurring() {
        if (type.equals("recurring")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean incompleteForm() {
        return envelopeName.getText().equals("") || total.getText().equals("") ||
                type.getSelectionModel().isEmpty() || stickied.getSelectionModel().isEmpty();
    }

    public void displayEnvelopes(Envelopes envelopes) {
        envelopeListView.setCellFactory(listView -> new EnvelopeFormatCell());
        envelopeListView.setItems(envelopes.get());
    }

    private void populateChoiceBoxes() {
        stickied.getItems().add("recurring");
        stickied.getItems().add("temporary");

        type.getItems().add(Envelope.EnvelopeCat.EMPTY);
        type.getItems().add(Envelope.EnvelopeCat.CREDITCARD);
        type.getItems().add(Envelope.EnvelopeCat.EATINGOUT);
        type.getItems().add(Envelope.EnvelopeCat.ENTERTAINMENT);
        type.getItems().add(Envelope.EnvelopeCat.GENERAL);
        type.getItems().add(Envelope.EnvelopeCat.GROCERIES);
        type.getItems().add(Envelope.EnvelopeCat.TRANSPORT);
        type.getItems().add(Envelope.EnvelopeCat.SAVINGS);
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }


    private class EnvelopeFormatCell extends ListCell<Envelope> {

        public EnvelopeFormatCell() {
            super();
        }

        @Override
        protected void updateItem(Envelope item, boolean empty) {
            super.updateItem(item, empty);
            initEnvelopeDisplay();

        }

        private void initEnvelopeDisplay() {
            System.out.println("running");
        }
    }
}