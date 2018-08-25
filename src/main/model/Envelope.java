package main.model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Envelope {

    private String name;
    private int fundsIn;
    private int fundsLeft;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label balance;

    @FXML
    private Button more;


    public Envelope() {
    }

    @FXML
    private void initialize() {

    }

    
    //TODO: instance variables - progress bar with a button at the start for properties
}
