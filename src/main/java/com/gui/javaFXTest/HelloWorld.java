package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

public class HelloWorld extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Test");

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (event -> {
            System.out.println("Key pressed: " + event.toString());

            switch (event.getCode().getCode()){
                case 27 : { // 27 = ESC key
                    primaryStage.close();
                    break;
                }
                case 10 : { // 10 = Return
                    primaryStage.setWidth( primaryStage.getWidth() * 2);
                }
                default: {
                    System.out.println("Unrecognized Key");
                }
            }
        }));


        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
