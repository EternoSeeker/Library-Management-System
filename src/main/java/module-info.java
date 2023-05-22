module com.example.librarydbnew {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires ojdbc6;

    opens com.example.librarydbnew to javafx.fxml;
    exports com.example.librarydbnew;
}