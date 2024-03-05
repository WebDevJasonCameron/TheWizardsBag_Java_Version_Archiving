package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ImageApp extends Application {

    // ATTs
    private final static String IMAGE_LOC = "images/MoonWave.png";

    // CONs

    // MTHs

    // OVRs
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image2 = new Image(IMAGE_LOC, 360.0d, 360.0d, true, true);
        Image image3 = new Image(IMAGE_LOC, 360.0d, 360.0d, false, true);
        Image image4 = new Image(IMAGE_LOC);
    }

    // RUN
    public static void main(String[] args) {
        launch(args);
    }
}
