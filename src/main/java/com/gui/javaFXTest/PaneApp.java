package com.gui.javaFXTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PaneApp extends Application {

    // OVRs
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Main Container
        VBox vBox = new VBox();
        vBox.setPadding( new Insets( 10 ) );
        vBox.setBackground(
                new Background(
                        new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0))
                )
        );

        // Build bg design with images
        Pane p = new Pane();

        // Center
        Arc largeArc = new Arc(0, 0, 100, 100, 270, 90);
        largeArc.setFill(Color.web("0x59291E"));
        largeArc.setType(ArcType.ROUND);
        // 2nd
        Arc backgroundArc = new Arc(0, 0, 160, 160, 270, 90);
        backgroundArc.setFill(Color.web("0xD96F32"));
        backgroundArc.setType(ArcType.ROUND);
        // bottom circle
        Arc smArc1 = new Arc(0, 160, 30, 30, 270, 180);
        smArc1.setFill(Color.web("0xF2A444"));
        smArc1.setType(ArcType.ROUND);
        // middle circle
        Circle smCircle = new Circle(
                160/Math.sqrt(2.0), 160/Math.sqrt(2.0), 30, Color.web("0xF2A444")
        );
        // top circle
        Arc smArc2 = new Arc( 160, 0, 30, 30, 180, 180);
        smArc2.setFill(Color.web("0xF2A444"));
        smArc2.setType(ArcType.ROUND);
        // link
        Hyperlink hyperlink = new Hyperlink("About this App");
        hyperlink.setFont( Font.font(36) );
        hyperlink.setTextFill( Color.web("0x3E6C93") );
        hyperlink.setBorder( Border.EMPTY );
        // bottom right circle
        Arc medArc = new Arc(568-20, 320-20, 60, 60, 90, 90);
        medArc.setFill(Color.web("0xD9583B"));
        medArc.setType(ArcType.ROUND);

        p.getChildren().addAll( backgroundArc, largeArc, smArc1, smCircle, smArc2, hyperlink, medArc );

        vBox.getChildren().add( p );

        Scene scene = new Scene(vBox);
        scene.setFill(Color.BLACK);

        primaryStage.setTitle("Pane App");
        primaryStage.setScene( scene );
        primaryStage.setWidth( 568 );
        primaryStage.setHeight( 320 );
        primaryStage.setOnShowing( (evt) -> {
            hyperlink.setLayoutX( 284 - (hyperlink.getWidth()/3) );
            hyperlink.setLayoutY( 160 - hyperlink.getHeight() );
        });
        primaryStage.show();
    }

    // RUN
    public static void main(String[] args) {
        launch(args);
    }
}





















