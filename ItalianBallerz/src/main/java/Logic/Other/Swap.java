package Logic.Other;

import GUI_Graphic_Controller.MainInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/* Ha la responsabilità di cambiare scene nei controller grafici */

public class Swap {
    public static String user = null;
    public static  String password =  null;


    public static void goTo(String s,AnchorPane mainPane){

        if((user != null && password != null) && s.compareTo("LoginInterface.fxml") == 0)
        {
            s = "LoggedInterface.fxml";
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

    public static void setPassword(String psw) {
        password = psw;
    }


    public static void setUser(String name) {
        user = name;
    }

}
