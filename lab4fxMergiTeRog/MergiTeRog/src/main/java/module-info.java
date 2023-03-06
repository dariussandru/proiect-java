module com.example.mergiterog {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.mergiterog to javafx.fxml;
    exports com.example.mergiterog;
    exports com.example.mergiterog.Controller;
    exports com.example.mergiterog.domain;
    opens com.example.mergiterog.Controller to javafx.fxml;
}