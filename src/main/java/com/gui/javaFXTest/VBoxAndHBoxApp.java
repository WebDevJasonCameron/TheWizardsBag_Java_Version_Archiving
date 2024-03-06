package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxAndHBoxApp extends Application {

    // ATTs
    private void loadTable(TableView<Customer> tblCustomer){
        tblCustomer.getItems().add(new Customer("George", "Washington"));
        tblCustomer.getItems().add(new Customer("Abe", "Lincoln"));
        tblCustomer.getItems().add(new Customer("Thomas", "Jefferson"));
    }

    // OVRs
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Main Container
        VBox vBox = new VBox();

        // Top Container
        HBox topControls = new HBox();
        VBox.setMargin( topControls, new Insets(10.0d));
        topControls.setAlignment(Pos.BOTTOM_LEFT);

        Button btnRefresh = new Button("Refresh");

        HBox topRightControls = new HBox();
        HBox.setHgrow(topRightControls, Priority.ALWAYS);
        topRightControls.setAlignment(Pos.BOTTOM_RIGHT);
        Hyperlink signOutLink = new Hyperlink("Sign Out");
        topRightControls.getChildren().add(signOutLink);

        topControls.getChildren().addAll( btnRefresh, topRightControls );

        // Table Container
        TableView<Customer> tblCustomers = new TableView<>();
        tblCustomers.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin( tblCustomers, new Insets(0.0d, 10.0d, 10.0d, 10.0d) );
        VBox.setVgrow( tblCustomers, Priority.ALWAYS );

        // Cols
        TableColumn<Customer, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Customer, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        tblCustomers.getColumns().addAll( lastNameCol, firstNameCol );

        Separator sep = new Separator();

        // Bottom Container
        HBox bottomControls = new HBox();
        bottomControls.setAlignment(Pos.BOTTOM_RIGHT);
        VBox.setMargin( bottomControls, new Insets(10.0d) );

        Button btnClose = new Button("Close");

        bottomControls.getChildren().addAll( btnClose );

        // Combine All into vBox
        vBox.getChildren().addAll(
                topControls,
                tblCustomers,
                sep,
                bottomControls
        );

        // Combine All into Scene
        Scene scene = new Scene(vBox);

        // Combine and Build Primary Stage
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle( "VBox and HBox App" );
        primaryStage.setOnShowing( (evt) -> loadTable(tblCustomers) );
        primaryStage.show();

    }

    // RUN
    public static void main(String[] args) {
        launch(args);
    }
}














