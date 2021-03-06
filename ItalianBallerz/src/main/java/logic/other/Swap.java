package logic.other;

import guicontroller.MainInterface;
import javafx.scene.text.Text;
import logic.bean.BeanLogin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;



/**
 * Ha la responsabilit√† di cambiare scene nei controller grafici della prima interfaccia grafica
 */
public class Swap {
    private Swap(){}

    public static void goTo(String s,AnchorPane mainPane){
        if((BeanLogin.getUsername() != null) && s.compareTo("LoginInterface.fxml") == 0)
        {
            s = "LoggedInterface.fxml";
        }
        else if((BeanLogin.getUsername() == null) && s.compareTo("StatsInterfaceUse.fxml") == 0)
        {
            s = "NotLoggedInterface.fxml";
        }

        Scene scene = null;

        try{
            Parent parent = FXMLLoader.load(Objects.requireNonNull(MainInterface.class.getResource(s)));
            scene = new Scene(parent);
        } catch (IOException e) {
            mainPane.getChildren().add(new Text("Errore di IO"));
        }
        
        Stage window;
        try {
            window = (Stage)mainPane.getScene().getWindow();
            Objects.requireNonNull(window).setScene(scene);
            Objects.requireNonNull(window).show();
        } catch (Exception e) {
            mainPane.getChildren().add(new Text("Errore"));
        }
    }
}
