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

    opens GUI to javafx.fxml;
    exports GUI;

    opens StatsLogic.Boundary to javafx.fxml;
    exports StatsLogic.Boundary;
    exports StatsLogic.Boundary.ControlView;
    opens StatsLogic.Boundary.ControlView to javafx.fxml;
}