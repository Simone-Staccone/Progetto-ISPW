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
    requires log4j;

    opens guicontroller to javafx.fxml;
    exports guicontroller;

    opens guicontroller2 to javafx.fxml;
    exports guicontroller2;

    opens logic.other to javafx.fxml;
    exports logic.other;
}