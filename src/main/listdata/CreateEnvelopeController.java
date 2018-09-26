package main.listdata;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.Main;
import main.baselayouts.MainController;

public class CreateEnvelopeController {

    private Main main;

    @FXML
    private TextField envelopeName;
    @FXML
    private TextField total;
    @FXML
    private ChoiceBox<Envelope.EnvelopeCat> type;
    @FXML
    private ChoiceBox<String> recurring;
    @FXML
    private Button confirmButton;

    private MainController mainController;
    private Stage stage;

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
        recurring.setValue("recurring");
    }

    private void clearEnvelopeInput() {
        envelopeName.clear();
        total.clear();
        type.setValue(null);
        recurring.setValue(null);
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
                clearEnvelopeInput();
                stage.hide();
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
                type.getSelectionModel().isEmpty() || recurring.getSelectionModel().isEmpty();
    }

    private void populateChoiceBoxes() {
        recurring.getItems().add("recurring");
        recurring.getItems().add("temporary");

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

    public void injectStage(Stage stage) {
        this.stage = stage;
    }
}