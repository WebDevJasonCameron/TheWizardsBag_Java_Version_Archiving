package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class FXMLExample extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        // This is the way!
        FXMLLoader loader = new FXMLLoader(FXMLExample.class.getResource("hello-world.fxml"));

        VBox vBox = loader.<VBox>load();

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}