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

    opens gui_Graphic_Controller to javafx.fxml;
    exports gui_Graphic_Controller;

    opens Logic.Other to javafx.fxml;
    exports Logic.Other;
}