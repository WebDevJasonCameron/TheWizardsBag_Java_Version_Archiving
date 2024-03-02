package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.sql.SQLOutput;

public class CombosApp extends Application {

    // ATTs
    private final ComboBox<Pair<String, String>> account = new ComboBox<>();
    private final static Pair<String, String> EMPTY_PAIR = new Pair<>("", "");

    // MTHs
    public void initCombo(){
        // <F> standby code
    }

    // OVRs
    @Override
    public void start(Stage primaryStage) throws Exception {

        Label accountsLabel = new Label("Account:");
        account.setPrefWidth(200);
        Button saveButton = new Button("Save");

        HBox hBox = new HBox(
                accountsLabel,
                account,
                saveButton
        );
        hBox.setSpacing( 10.0d );
        hBox.setAlignment( Pos.CENTER );
        hBox.setPadding( new Insets(40));

        Scene scene = new Scene(hBox);

        initCombo();            // <!> Added after this

        saveButton.setOnAction( (evt) -> {
            if( account.getValue().equals(EMPTY_PAIR)) {
                System.out.println("no save needed; no item selected");
            } else {
                System.out.println("saving " + account.getValue());
            }
        });

        primaryStage.setTitle("CombosApp");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
}
















