package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CombosApp extends Application {

    // ATTs
    private final ComboBox<Pair<String, String>> account = new ComboBox<>();
    private final static Pair<String, String> EMPTY_PAIR = new Pair<>("", "");

    // MTHs
    public void initCombo(){
        List<Pair<String, String>> accounts = new ArrayList<>();

        accounts.add( new Pair<>("Auto Express", "60000"));
        accounts.add( new Pair<>("Interest Express", "61000"));
        accounts.add( new Pair<>("Office Express", "62000"));
        accounts.add( new Pair<>("Salaries Express", "63000"));

        account.getItems().add( EMPTY_PAIR );
        account.getItems().addAll( accounts );
        account.setValue( EMPTY_PAIR );

        Callback<ListView<Pair<String, String>>, ListCell<Pair<String, String>>> factory = (lvl) -> new ListCell<Pair<String, String>>() {
            @Override
            protected void updateItem(Pair<String, String> item, boolean empty){
                super.updateItem(item, empty);
                if( empty ) {
                    setText("");
                } else {
                    setText( item.getKey() );
                }
            }
        };

        account.setCellFactory( factory );
        account.setButtonCell( factory.call( null ));
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

        initCombo();

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
















