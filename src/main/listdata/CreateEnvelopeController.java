package main.listdata;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.Main;

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

    public CreateEnvelopeController() {
    }

    @FXML
    private void initialize() {
        dialogButtonAction();
        populateChoiceBoxes();
    }

    public void setEnvelopeList(ListView<Envelope> envelopeList) {
        envelopeListView = envelopeList;
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

    public Envelope createEnvelope() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/listdata/CreateEnvelope.fxml"));
            Scene scene = new Scene(root);
            this.stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        } catch(IOException e) {
            e.printStackTrace();
        }

        int totalInt = Integer.parseInt(total.getText());
        return new Envelope(envelopeName.getText(), type.getValue(), totalInt, isRecurring());
    }

    @FXML
    private void dialogButtonAction() {
        confirmButton.setOnAction(event -> {
            if(incompleteForm()) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setContentText("Fields have not been completed");
                error.showAndWait();
            }
        });
    }

    private boolean isRecurring() {
        if(type.equals("recurring")) {
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

    public void setMainApp(Main main) {
        this.main = main;
    }
}

