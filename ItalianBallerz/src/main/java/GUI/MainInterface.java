package GUI;

import StatsLogic.Control.LoginControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class MainInterface extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader xml =  new FXMLLoader(MainInterface.class.getResource("MainInterface.fxml"));
        Scene scene = new Scene(xml.load());
        //stage.setMaximized(true);
        stage.setResizable(false);
        stage.setTitle("Italian Ballerz");
        stage.setScene(scene);
        stage.show();
        LoginControl lg = new LoginControl();
        System.out.println(lg.getUser());
    }


    public static void main(String[] args) {
        launch();
    }

    public static void tryLaunch()
    {
        launch();
    }
}