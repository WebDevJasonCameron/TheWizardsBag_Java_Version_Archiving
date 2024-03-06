package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableView;
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
        TableView<Customer> tblCustomer = new TableView<>();
        tblCustomer.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin( tblCustomer, new Insets(0.0d, 10.0d, 10.0d, 10.0d) );
        VBox.setVgrow( tblCustomer, Priority.ALWAYS );


    }

    // RUN
    public static void main(String[] args) {
        launch(args);
    }
}














