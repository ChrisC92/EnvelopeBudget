package main.listdata;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import main.Main;

import java.io.IOException;

public class EnvelopeController {

    private Main main;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label balance;

    @FXML
    private Button more;

    private ListView<Envelope> envelopeListView;

    public EnvelopeController() {
    }

    @FXML
    private void initialize() {
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

    public void displayEnvelopes(Envelopes envelopes) {
        envelopeListView.setCellFactory(listView -> new EnvelopeFormatCell());
        envelopeListView.setItems(envelopes.get());
    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}

