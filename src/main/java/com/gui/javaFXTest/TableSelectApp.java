package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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

        tblItems.getItems().addAll(
                new Item("Kbd-0455892", "Mechanical Keyboard", 100.0f, true),
                new Item("145266", "Product Docs", 0.0f, false),
                new Item("OR-198975", "O-Ring (100)", 10.0f, true)
        );

        Button btnInventory = new Button("Inventory");
        Button btnCalcTax = new Button("Tax");

        btnInventory.disableProperty().bind(
                tblItems.getSelectionModel().selectedItemProperty().isNull() );

        btnCalcTax.disableProperty().bind(
                tblItems.getSelectionModel().selectedItemProperty().isNull().or(
                        Bindings.select(
                                tblItems.getSelectionModel().selectedItemProperty(),
                                "taxable"
                        ).isEqualTo(false)
                )
        );

        HBox buttonHBox = new HBox( btnInventory, btnCalcTax );
        buttonHBox.setSpacing( 8 );

        VBox vBox = new VBox( tblItems, buttonHBox );
        vBox.setPadding( new Insets(10) );
        vBox.setSpacing( 10 );

        Scene scene = new Scene(vBox);

        primaryStage.setTitle( "TableSelectApp" );
        primaryStage.setScene( scene );
        primaryStage.setHeight( 367 );
        primaryStage.setWidth( 667 );
        primaryStage.show();

    }

    // RUN
    public static void main(String[] args) {
        launch(args);
    }
}



















