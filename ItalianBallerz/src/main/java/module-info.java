module com.example.italianballerz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens GUI_Graphic_Controller to javafx.fxml;
    exports GUI_Graphic_Controller;

    opens Logic.Other to javafx.fxml;
    exports Logic.Other;
}