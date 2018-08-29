package main.model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import main.Main;

public class Envelope {

    private String name;
    private int totalFunds;
    private int fundsLeft;
    private Main main;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label balance;

    @FXML
    private Button more;


    public Envelope() {
    }

    public Envelope(String name) {
        this.name = name;
    }


    public Envelope(String name, int funds) {
        this.name = name;
        totalFunds = funds;
        fundsLeft = funds;
    }

    public Envelope(String name, int funds, int fundsLeft) {
        this.name = name;
        totalFunds = funds;
        fundsLeft = fundsLeft;
    }

    @FXML
    private void initialize() {
    }

    public String getName() {
        return name;
    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
