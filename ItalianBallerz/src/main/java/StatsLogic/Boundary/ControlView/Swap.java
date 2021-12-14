package StatsLogic.Boundary.ControlView;

import GUI.MainInterface;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Swap {


    public static void goTo(String s,AnchorPane mainPane){
        try{
            Parent parent = FXMLLoader.load(MainInterface.class.getResource(s));
            Scene scene = new Scene(parent);
            Stage window = null;
            try {
                window = (Stage)mainPane.getScene().getWindow();
            } catch (Exception e) {
                System.out.println("Trovato errore nello swap");
            }
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
