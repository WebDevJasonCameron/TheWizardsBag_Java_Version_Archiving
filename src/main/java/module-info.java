module TheWizardsBag {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.gui.javaFXTest to HelloWorld;
    exports com.gui.javaFXTest;
}