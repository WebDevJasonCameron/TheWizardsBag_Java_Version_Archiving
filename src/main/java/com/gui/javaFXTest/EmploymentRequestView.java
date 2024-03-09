package com.gui.javaFXTest;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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
