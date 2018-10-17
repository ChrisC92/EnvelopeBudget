package main.java.listdata;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EnvelopeProgressBar extends Application {


    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        scene.getStylesheets().add("progresssample/Style.css");
        stage.setScene(scene);
        stage.setTitle("Progress Controls");

        ProgressBar pb = new ProgressBar(0.6);
        ProgressIndicator pi = new ProgressIndicator(0.6);

        final HBox hBox = new HBox();
        hBox.setSpacing(5);
        hBox.getChildren().addAll(pb, pi);
        scene.setRoot(hBox);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}