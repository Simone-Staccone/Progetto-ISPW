package Logic.Other;

import gui_Graphic_Controller.MainInterface;
import Logic.Bean.BeanLogin;
import Logic.Entity.PlayerUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/* Ha la responsabilità di cambiare scene nei controller grafici */

public class Swap {
    public static void goTo(String s,AnchorPane mainPane){
        if((BeanLogin.getUsername() != null) && s.compareTo("LoginInterface.fxml") == 0)
        {
            s = "LoggedInterface.fxml";
        }
        else if((BeanLogin.getUsername() == null) && s.compareTo("StatsInterfaceUse.fxml") == 0)
        {
            s = "NotLoggedInterface.fxml";
        }
        try{
            Parent parent = FXMLLoader.load(Objects.requireNonNull(MainInterface.class.getResource(s)));
            Scene scene = new Scene(parent);
            Stage window = null;
            try {
                window = (Stage)mainPane.getScene().getWindow();
            } catch (Exception e) {
                System.out.println("Trovato errore nello swap");
            }
            try {
                Objects.requireNonNull(window).setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Objects.requireNonNull(window).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
