module com.gui.javaFXTest {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.gui.javaFXTest;
    exports com.gui.javaFXTest;
}

