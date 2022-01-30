package logic.other;

import javafx.scene.text.Text;
import second_guicontroller.LoginFormController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Ha la responsabilità di cambiare scene nei controller grafici della seconda interfaccia grafica
 */
public class Swap2 {
    private Swap2(){

    }

    public static void goTo(String s, AnchorPane mainPane){
        try{
            Parent parent = FXMLLoader.load(Objects.requireNonNull(LoginFormController.class.getResource(s)));
            Scene scene = new Scene(parent);
            Stage window = (Stage)mainPane.getScene().getWindow();
            Objects.requireNonNull(window).setScene(scene);
            Objects.requireNonNull(window).show();
        } catch (Exception e) {
            mainPane.getChildren().add(new Text("Errore"));
        }
    }
}
