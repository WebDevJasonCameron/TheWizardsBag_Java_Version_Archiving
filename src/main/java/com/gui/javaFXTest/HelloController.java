package com.gui.javaFXTest;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public void buttonClicked(Event e) {
        System.out.println("Button Clicked");
    }
}
