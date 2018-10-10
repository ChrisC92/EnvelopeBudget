package main.java.baselayouts;

import javafx.fxml.Initializable;
import main.java.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    private MainController mainController;
    private Main main;


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(Main mainApp) {
        this.main = mainApp;
    }

    public void doExit() {
    }
}
