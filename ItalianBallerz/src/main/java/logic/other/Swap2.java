package logic.other;

import second_guicontroller.LoginFormController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

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
            e.printStackTrace();
        }
    }
}
