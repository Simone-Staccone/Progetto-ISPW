package logic.other;

import guicontroller2.LoginFormController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Swap2 {
    public static void goTo(String s, AnchorPane mainPane){
        Scene scene = null;
        try{
            Parent parent = FXMLLoader.load(Objects.requireNonNull(LoginFormController.class.getResource(s)));
            scene = new Scene(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage window;
        try {
            window = (Stage)mainPane.getScene().getWindow();
            Objects.requireNonNull(window).setScene(scene);
            Objects.requireNonNull(window).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
