package main;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.baselayouts.MainController;
import main.baselayouts.RootController;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private MainController mainController;
    private RootController rootController;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        initRootLayout();
        initMainLayout();
    }


    /**
     * Rootlayout contains the menu bar UI
     */
    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/main/baselayouts/RootLayout.fxml"));
            rootLayout = loader.load();
            rootController = loader.getController();
            rootController.setMainApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setOnHidden(e -> rootController.doExit());
            primaryStage.show();
        } catch(IOException io) {
            io.printStackTrace();
        }


    }

    /**
     *  main.Main layout handles rest of the GUI, links the root layout with main layout to create
     *  main window of the program
     */
    private void initMainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/main/baselayouts/MainLayout.fxml"));
            AnchorPane mainLayout = loader.load();
            rootLayout.setCenter(mainLayout);
            mainController = loader.getController();
            mainController.setStage(primaryStage);
            mainController.setMainApp(this);
            rootController.setMainController(mainController);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
