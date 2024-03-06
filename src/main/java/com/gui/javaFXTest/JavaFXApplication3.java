package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

public class JavaFXApplication3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Image smash = new Image(getClass().getResource("images/MoonWave.png").toString());
        Image smash = new Image(new File("images/MoonWave.png").toURI().toString());
        ImageView smashImage = new ImageView(smash);

        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();

        btn1.setText("Button 1");
        btn2.setText("Button 2");
        btn3.setText("Button 3");
        btn4.setText("Button 4");

        Group root = new Group();
        HBox nav = new HBox();

        nav.getChildren().addAll(btn1, btn2, btn3, btn4);
        root.getChildren().add(nav);
        //root.getChildren().add(smashImage);
        nav.setLayoutY(225);
        nav.setLayoutX(25);
        smashImage.setLayoutX(110);
        smashImage.setLayoutY(35);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World App!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}
