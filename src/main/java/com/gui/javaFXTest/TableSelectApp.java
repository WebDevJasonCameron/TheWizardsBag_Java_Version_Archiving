package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableSelectApp extends Application {

    // ATTs

    // CONs

    // MTHs

    // OVRs
    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Item> tblItems = new TableView<>();

        tblItems.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox.setVgrow(tblItems, Priority.ALWAYS);

        TableColumn<Item, String> colSKU = new TableColumn<>("SKU");
        TableColumn<Item, String> colDesc = new TableColumn<>("Item");
        TableColumn<Item, String> colPrice = new TableColumn<>("Price");
        TableColumn<Item, String> colTaxable = new TableColumn<>("Tax");

        colSKU.setCellValueFactory( new PropertyValueFactory<>("sku") );
        colDesc.setCellValueFactory( new PropertyValueFactory<>("descr") );
        colPrice.setCellValueFactory( new PropertyValueFactory<>("price") );
        colTaxable.setCellValueFactory( new PropertyValueFactory<>("taxable") );

        tblItems.getColumns().addAll(
                colSKU, colDesc, colPrice, colTaxable
        );


    }
}



















