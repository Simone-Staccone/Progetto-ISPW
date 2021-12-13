package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StatsInterface extends Application {




    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader xml =  new FXMLLoader(MainInterface.class.getResource("StatsInterface.fxml"));
        Scene scene = new Scene(xml.load());
        //stage.setMaximized(true);
        stage.setResizable(false);
        stage.setTitle("Italian Ballerz");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    public static void tryLaunch()
    {
        launch();
    }
}