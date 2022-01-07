package logic.other;

import guicontroller.MainInterface;
import logic.bean.BeanLogin;
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
            Stage window;
            try {
                window = (Stage)mainPane.getScene().getWindow();
                Objects.requireNonNull(window).setScene(scene);
                Objects.requireNonNull(window).show();
            } catch (Exception e) {
                System.err.println("Trovato errore nello swap");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
