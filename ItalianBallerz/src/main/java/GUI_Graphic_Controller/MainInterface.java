package gui_Graphic_Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class MainInterface extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader xml =  new FXMLLoader(MainInterface.class.getResource("MainInterface.fxml"));
        Scene scene = new Scene(xml.load());
        stage.setResizable(false);
        stage.setTitle("Italian Ballerz");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}