package com.gui.javaFXTest;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.nio.MappedByteBuffer;

public class EmploymentRequestView extends MappedByteBuffer {
    private GridPane gp = new GridPane();

    private TextField tfName = new TextField();
    private TextField tfPosition = new TextField();
    private TextField tfAnnualSalary = new TextField();

    private Button btnSave = new Button("Save");
    private Button btnCancel = new Button("Cancel");
    private Button btnReset = new Button("Reset");

    public EmploymentRequestView() {
        createView();
        bindViewModel();
    }

    private void createView(){
        VBox gpwrap = new VBox();
        gpwrap.setAlignment( Pos.CENTER );

        gp.setPadding( new Insets( 40) );
        gp.setVgap( 4 );
        gp.add( new Label("Name"), 0 , 0);
        gp.add( tfName, 1, 0 );

    }
}













